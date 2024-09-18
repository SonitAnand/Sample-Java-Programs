package org.example.sample1;

class ThreadA extends Thread {
    public void run() {
        System.out.println("ThreadA is running");
    }
}

class ThreadB implements Runnable {
    public void run() {
        System.out.println("ThreadB is running");
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        threadA.start();

        ThreadB threadB = new ThreadB();
        Thread thread = new Thread(threadB);
        thread.start();
    }
}
