package com.example.snippets.demo.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManagerNOSafeThread {
    private int sheepCount = 0;

    private void incrementAndReport() {
        System.out.print((++sheepCount) + " ");
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManagerNOSafeThread manager = new SheepManagerNOSafeThread();
            for (int i = 0; i < 10; i++)
                service.submit(manager::incrementAndReport);
        } finally {
            if (service != null) service.shutdown();
        }
    }


}
