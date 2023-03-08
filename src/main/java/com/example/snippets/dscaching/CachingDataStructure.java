package com.example.snippets.dscaching;

import java.util.*;

interface TimeProvider {
    long getMillis();
}

class CachingEntry {
    private String key;
    private String value;
    private Long timeToLive;

    public CachingEntry(String key, String value, Long timeToLive) {
        this.key = key;
        this.value = value;
        this.timeToLive = timeToLive;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public Long getTimeToLive() {
        return timeToLive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CachingEntry)) return false;
        CachingEntry entry = (CachingEntry) o;
        return key.equals(entry.key) && value.equals(entry.value) && timeToLive.equals(entry.timeToLive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return "CachingEntry{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", timeToLive=" + timeToLive +
                '}';
    }
}

public class CachingDataStructure {

    private int maxSize;
    private TimeProvider timeProvider;

    private CachingEntry[] values;

    private long[] times;

    private int currentSize;

    CachingDataStructure(TimeProvider timeProvider, int maxSize) {
        this.timeProvider = timeProvider;
        this.maxSize = maxSize;
        this.values = new CachingEntry[maxSize];
        this.times = new long[maxSize];
        this.currentSize = 0;
    }

    public void put(String key, String value, long timeToLeaveInMilliseconds) {
        if (timeToLeaveInMilliseconds <= 0) {
            throw new IllegalArgumentException("The time can not be negative");
        }

        if (key == null) {
            throw new IllegalArgumentException("Key can not be null");
        }

        if (value == null) {
            throw new IllegalArgumentException("Value can not be null");
        }

        long offSet = timeProvider.getMillis() + timeToLeaveInMilliseconds;

        CachingEntry entry = new CachingEntry(key, value, offSet);
        int position = computePosition(entry.hashCode());
        if (values[position] == null) {
            values[position] = entry;
            times[position] = entry.getTimeToLive();
            increaseCurrentSize();
        } else {
            if (values[position].getKey().equals(entry.getKey())) {
                values[position] = entry;
                times[position] = entry.getTimeToLive();
            } else {
                int i = position + 1;
                while (i < values.length) {
                    if (values[i] == null) {
                        values[i] = entry;
                        times[i] = entry.getTimeToLive();
                        increaseCurrentSize();
                        break;
                    }
                    i++;
                    if (i == values.length) {
                        i = 0;
                    }
                    if (i == position) {
                        break;
                    }
                }
            }
        }
    }

    public Optional<String> get(String key) {
        if (currentSize == 0) {
            return Optional.empty();
        }
        int position = computePosition(Objects.hash(key));
        if (values[position] != null && values[position].getKey().equals(key)) {
            if (checkTime(times[position], position)) {
                return Optional.of(values[position].getValue());
            }
        } else {
            int i = position + 1;
            while (i < values.length) {
                if (values[i] != null && values[i].getKey().equals(key)) {
                    if (checkTime(times[i], i)) {
                        return Optional.of(values[i].getValue());
                    }
                }
                i++;
                if (i == values.length) {
                    i = 0;
                }
                if (i == position) {
                    break;
                }
            }
        }
        return Optional.empty();
    }

    private boolean checkTime(long timeToLive, int position) {
        System.out.println("ETime " + timeToLive + " Provi " + timeProvider.getMillis() + " RES " + (timeToLive - timeProvider.getMillis()));
        boolean isAvailable = (timeToLive - timeProvider.getMillis()) > 0;
        if (!isAvailable && values[position] != null) {
            values[position] = null;
            times[position] = 0L;
            decreaseCurrentSize();
        }
        return isAvailable;
    }

    public int size() {
        for (int i = 0; i < maxSize; i++) {
            if (times[i] > 0L) {
                checkTime(times[i], i);
            }
        }
        return currentSize;
    }

    private void decreaseCurrentSize() {
        currentSize--;
    }

    private void increaseCurrentSize() {
        currentSize++;
    }

    private int computePosition(int hashCode) {
        return Math.abs(hashCode) % maxSize;
    }

    public static void main(String[] args) {
        CachingDataStructure caching = new CachingDataStructure(System::currentTimeMillis, 5);

        //caching.put("uno", "Val", 10000L);
        caching.put("dos", "Val2", 20000L);
        /*caching.put("tres", "Val3", 10000L);
        caching.put("cuatro", "Val4", 10000L);
        caching.put("cinco", "Val5", 10000L);
        caching.put("cinco", "Val5REPLACE", 10000L);
        caching.put("diexz", "ValDiexz", 10000L);*/

        try {
            Thread.sleep(10001L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(System.currentTimeMillis());
        System.out.println("SIZE " + caching.size());

        System.out.println(caching.get("dos"));

        Arrays.stream(caching.values).forEach(System.out::println);
    }
}
