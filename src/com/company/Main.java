package com.company;

import java.util.Scanner;

public class Main {
    static int counter = 0;
    public static void main(String[] args) throws InterruptedException {

//        Thread counterThread = new Thread(() -> {
////            while(true){
//            try {
//                while (true) {
//                    counter++;
//                    System.out.println(counter);
//                    Thread.sleep(1000);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                Thread.currentThread().interrupt();
//            }
////        }
//        });


        CounterClass newCounterThread = new CounterClass();
        Thread newThread = new Thread(newCounterThread);
        newThread.start();
        Scanner input = new Scanner(System.in);
        int inputLine = input.nextInt();
        System.out.println("Main thread");
        newThread.interrupt();
        newThread.join();
        System.out.println("Get counter: " + newCounterThread.getCounter());
    }
}
