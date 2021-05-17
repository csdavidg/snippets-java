package com.example.snippets.demo.multithread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadApplicationUsingScheduleExecutorService {

    private static final Runnable printFinishedRunnable = () -> System.out.println("Task Executed");

    public static void main(String[] args) {
        System.out.println(firstExampleUsingScheduleWithDelay());
        System.out.println(secondExampleUsingScheduleAtFixedRateMethod());
        System.out.println(thirdExampleUsingScheduleWithFixedDelayMethod());
    }

    public static String thirdExampleUsingScheduleWithFixedDelayMethod(){
        ScheduledExecutorService ses = null;
        try{
            ses = Executors.newSingleThreadScheduledExecutor();
            ses.scheduleWithFixedDelay(printFinishedRunnable, 10, 30, TimeUnit.SECONDS);
        }finally {
            if(ses != null){
                ses.shutdown();
            }
        }
        return "Return of the third task";
    }

    private static String secondExampleUsingScheduleAtFixedRateMethod(){
        ScheduledExecutorService ses = null;
        try{
            ses = Executors.newSingleThreadScheduledExecutor();
            ses.scheduleAtFixedRate(printFinishedRunnable, 30, 10, TimeUnit.SECONDS);
        }finally {
            if(ses != null){
                ses.shutdown();
            }
        }
        return "Return of the second task";
    }

    private static String firstExampleUsingScheduleWithDelay() {
        ScheduledExecutorService ses = null;
        try{
            ses = Executors.newSingleThreadScheduledExecutor();
            ses.schedule(printFinishedRunnable,1, TimeUnit.MINUTES);
        }finally {
            if(ses != null){
                ses.shutdown();
            }
        }
        return "Return of the First task";
    }

}
