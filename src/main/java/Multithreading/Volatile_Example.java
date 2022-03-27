package Multithreading;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Volatile_Example {
    //static volatile int a,b ;
    static AtomicInteger a = new AtomicInteger();
    static AtomicInteger b = new AtomicInteger();
    public static void increment(){
        //a++;
        a.getAndIncrement();
        b.getAndIncrement();
        //b++;
    }
    public static void display(){
        System.out.println("a="+a+" b =" +b);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(){
        public void run()
        {
            for (int i = 0; i < 5; i++)
                increment();
        }
    };
        Thread t2 = new Thread(){
            public void run()
            {
                for (int i = 0; i < 5; i++)
                    display();
            }
        };
        t1.start();
        t2.start();


    }
}
