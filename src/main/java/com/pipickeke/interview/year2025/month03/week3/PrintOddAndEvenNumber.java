package com.pipickeke.interview.year2025.month03.week3;


/**
 *
 * 问题：
 *      用两个java线程，交替打印奇偶数
 *
 */

public class PrintOddAndEvenNumber {

    public static void main(String[] args) {
        Print bean = new Print(20);
        Thread oddthread = new Thread(bean::printOdd, "oddthread");
        Thread eventhread = new Thread(bean::printEven, "eventhread");
        oddthread.start();
        eventhread.start();
    }





}

class Print {
    private final int max;
    private int number = 1;

    public Print(int max) {
        this.max = max;
    }

    public synchronized void printOdd(){
        while (number <= max){
            if (number % 2 == 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    //throw new RuntimeException(e);
                }
            }
            if (number <= max){
                System.out.println(Thread.currentThread().getName()
                        + " : " + number);
                number++;
                notify();
            }

        }
    }

    public synchronized void printEven(){
        while (number <= max){
            if (number % 2 == 1){
                try {
                    wait();
                } catch (InterruptedException e) {
                    //throw new RuntimeException(e);
                }
            }
            if (number <= max){
                System.out.println(Thread.currentThread().getName()
                        +" : "+ number);
                number++;
                notify();
            }
        }
    }

}



