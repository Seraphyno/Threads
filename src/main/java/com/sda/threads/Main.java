package com.sda.threads;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            numbers.add(i);
        }

        Thread t1 = new Thread(new Adder(1,250));
        Thread t2 = new Thread(new Adder(251,500));
        Thread t3 = new Thread(new Adder(501,750));
        Thread t4 = new Thread(new Adder(751,1000));
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Adder implements Runnable {
    int a,b;

    public Adder(int a, int b){
        this.a = a;
        this.b = b;
    }
    public void run() {
        add(a,b);
    }

    int add(int a, int b) {
        long startTime = System.nanoTime();
        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += i;
        }

        long endTime = System.nanoTime();
        System.out.println("Took " + (endTime - startTime) + " nanos");
        return sum;
    }
}
