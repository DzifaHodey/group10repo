package com.company;

public class CounterClass implements Runnable{
    int counter=0;
    @Override
    public void run() {
        try {
            while (true) {
                counter++;
                System.out.println(counter);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public int getCounter() {
        return counter;
    }
}
