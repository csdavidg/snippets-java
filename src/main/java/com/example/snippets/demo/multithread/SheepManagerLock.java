package com.example.snippets.demo.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class SheepManagerLock extends ReentrantLock {

    private int sheepCount = 0;

    private void incrementAndReport() {
        try {
            this.lock();
            System.out.print(++sheepCount + " ");
        } finally {
            this.unlock();
        }

    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManagerLock manager = new SheepManagerLock();
            for (int i = 0; i < 10; i++)
                service.submit(manager::incrementAndReport);
        } finally {
            if (service != null) service.shutdown();
        }
    }

}
