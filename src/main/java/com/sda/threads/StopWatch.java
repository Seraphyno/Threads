package com.sda.threads;

public class StopWatch extends Thread {

    @Override
    public void run() {
        System.out.println("One spawned thread of type StopWatch starts");
        for (int i = 10; i >= 0; i--) {
            System.out.println("Timer: " + i);
            try {
                Thread.sleep(1000);
                //note that time is expressed in milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
