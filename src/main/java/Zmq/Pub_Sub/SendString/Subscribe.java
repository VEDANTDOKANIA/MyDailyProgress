package Zmq.Pub_Sub.SendString;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.io.IOException;

public class Subscribe {
    public static void main(String[] args) {
        /*try(ZContext context = new ZContext()){
            ZMQ.Socket socket = context.createSocket(SocketType.SUB);
            socket.connect("tcp://*:5553");
            *//*Scanner scanner = new Scanner(System.in);
            System.out.println("Enter topic to receive");
            String topic = scanner.next();*//*
            socket.subscribe("0");
            while (true){
                String message =socket.recvStr();
                System.out.println(message);
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }*/

        try (ZContext context = new ZContext()) {
            // Socket to talk to clients
            Runtime.getRuntime().exec("/home/vedant/JunitMaven/src/main/java/Zmq/Pub_Sub/SendString/zmq.exe");
            ZMQ.Socket socket = context.createSocket(SocketType.SUB);
            socket.connect("ipc://home/vedant/Documents/Zmq");
            

            socket.subscribe("0");
            for (int i = 1; i <= 100; i++) {
                System.out.println("received = " + socket.recvStr(1));
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
