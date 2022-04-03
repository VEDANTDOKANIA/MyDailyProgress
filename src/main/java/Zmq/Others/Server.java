package Zmq.Others;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class Server {
    public static void main(String[] args) {
        try(ZContext context = new ZContext()){
            ZMQ.Socket socket = context.createSocket(SocketType.PUB);
            socket.bind("tcp://127.0.0.1:5555");
            while (true){
                String response = "Hello, world!";
                socket.send(response);

            }


           // System.out.println("recevied " + socket.recvStr());
          /*  while (!Thread.currentThread().isInterrupted()) {
                // Block until a message is received
                byte[] reply = socket.recv(0);

                // Print the message
                System.out.println(
                        "Received: [" + new String(reply, ZMQ.CHARSET) + "]"
                );

                // Send a response
                *//*String response = "Hello, world!";
                socket.send(response.getBytes(ZMQ.CHARSET), 0);*//*
            }*/


        }catch (Exception e){
            System.out.println(e);
        }
    }

}
