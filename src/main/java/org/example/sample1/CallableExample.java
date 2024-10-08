package org.example.sample1;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class CallableFutureTest implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        // Create random number generator
        Random generator = new Random();
        Integer randomNumber = generator.nextInt(5);
        // we delay the thread for some random time 
        Thread.sleep(randomNumber * 1000);
        return randomNumber;
    }
}

public class CallableExample {
    public static void main(String[] args) throws Exception {
        //FutureTask is a concrete class that implements both Runnable and Future
        FutureTask[] randomNumberTasks = new FutureTask[5];
        for (int i = 0; i < 5; i++) {
            Callable callable = new CallableFutureTest();
            // Create the FutureTask with Callable
            randomNumberTasks[i] = new FutureTask(callable);
            Thread t = new Thread(randomNumberTasks[i]);
            t.start();
        }
        for (int i = 0; i < 5; i++) {
            // As it implements Future, we can call get()
            System.out.println(randomNumberTasks[i].get());
            // This method blocks till the result is obtained
            // The get method can throw checked exceptions like when it is interrupted. This is the reason for adding the throws clause to main
        }
    }
}