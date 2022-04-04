package Zmq.Pub_Sub.ByteArray;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Subscribe {
    public static void main(String[] args) {
        try(ZContext context = new ZContext()) {
            ZMQ.Socket socket = context.createSocket(SocketType.SUB);
            socket.connect("ipc://127.0.0.1:5553");
            Scanner scn = new Scanner(System.in);
            System.out.println("Enter Topic:");
            String topic = scn.next();
            byte[] topicarray = topic.getBytes(StandardCharsets.UTF_8);
            socket.subscribe(topicarray);
            String message = new String(socket.recv());
            String[] messageArray = message.split(topic);
            System.out.println(messageArray[1]);


        }
    }
}
