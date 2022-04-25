package com.geekbrains.lesson5.runnable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample implements Callable {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future submit = executorService.submit(new CallableExample());

        Future<?> future2 = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("finish");
            }
        });


//        System.out.println(submit.get());
        System.out.println(future2.get());
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "finish";
    }
}
