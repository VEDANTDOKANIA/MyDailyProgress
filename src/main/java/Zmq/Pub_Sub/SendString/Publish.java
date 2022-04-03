package Zmq.Pub_Sub.SendString;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.util.Scanner;

public class Publish {
    public static void main(String[] args) {
        try(ZContext context = new ZContext()){
            ZMQ.Socket socket = context.createSocket(SocketType.PUB);
            socket.bind("tcp://127.0.0.1:5554");
            Scanner scanner = new Scanner(System.in);
            while (true){
            System.out.println("Enter the topic:");
            String topic = scanner.next();
            System.out.println("Enter the msg");
            String message = scanner.next();
            String messageToSend = String.format(topic+message);
            //System.out.println(messageToSend);
            socket.send(messageToSend);
            Thread.sleep(1000);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
