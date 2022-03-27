package Multithreading;

public class Multithreading_Example {
    public static void main(String[] args) throws InterruptedException {
        while (true){
            Thread t1 = new Thread("Vedant");
            t1.setDaemon(true);
            t1.start();

            //t1.join// t1 phela aapna kaam karenga than t2
            Thread.currentThread().join();// Isske neecha ke statement execute nahi honga. Main thread khud ka hee wait karenga khatam hona ka
            System.out.println(t1.getState());
            System.out.println(t1.getName());
            System.out.println(t1.isDaemon());
            System.out.println(t1.getPriority()); // by default priority is 5

            t1.setPriority(10);
            System.out.println(t1.isDaemon());
            System.out.println(t1.getPriority());

            Thread.sleep(10000);
            Thread t2 = new Thread();
            t2.join();
            System.out.println(t2.getState());
            System.out.println(t2.getId());
            System.out.println(t2.isDaemon());
        }

    }
}
