package com.example.springjpa.thread;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Callable callable=()->{
            System.out.println("cancel......b");
            Thread.sleep(2000);
            System.out.println("cancel......a");
            return "hello";
        };

        FutureTask<String> futureTask=new FutureTask<String>(callable);
        Thread t1=new Thread(()->{
            futureTask.run();
        },"t1..");
        t1.start();
        Thread.sleep(100);
        //futureTask.cancel(true);
        System.out.println(futureTask.get(3000, TimeUnit.MILLISECONDS));
    }
}
