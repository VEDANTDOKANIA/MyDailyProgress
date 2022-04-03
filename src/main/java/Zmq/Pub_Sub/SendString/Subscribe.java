package Zmq.Pub_Sub.SendString;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.util.Scanner;

public class Subscribe {
    public static void main(String[] args) {
        try(ZContext context = new ZContext()){
            ZMQ.Socket socket = context.createSocket(SocketType.SUB);
            socket.connect("tcp://127.0.0.1:5554");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter topic to receive");
            String topic = scanner.next();
            socket.subscribe(topic);
            String message =socket.recvStr();
            System.out.println(message);
        }
    }
}
