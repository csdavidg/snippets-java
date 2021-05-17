package com.example.snippets.demo.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManagerSynchronized {

    private int sheepCount = 0;

    private void incrementAndReport() {
        //This option also works for incrementing the value in order
//        synchronized (this) {
        System.out.print(++sheepCount + " ");
//        }
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManagerSynchronized manager = new SheepManagerSynchronized();
            for (int i = 0; i < 10; i++)
                service.submit(() -> {
                    synchronized (manager) {
                        manager.incrementAndReport();
                    }
                });
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
