package com.example.snippets.demo.multithread;

public class ReadInventoryThread extends Thread {

    @Override
    public void run() {
        System.out.println("Printing read inventory");
    }

    public static void main(String[] args) {
        new ReadInventoryThread().start();
    }


}
