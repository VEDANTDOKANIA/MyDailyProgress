package Multithreading;

import java.util.Scanner;

public class SpawnMultipleThreads {
    public static void main(String[] args) {
        System.out.println("Enter number of threads to be spawn");
        Scanner scanner= new Scanner(System.in);
        int threadTotal = scanner.nextInt();
        for(int i =0; i<threadTotal;i++){
            Thread thread = new Thread("ThreadName"+i){
                public void run(){

                    for(int i =0;i<=10;i++){
                        System.out.println(i);
                    }
                }
            };
            thread.start();
        }
    }
}
