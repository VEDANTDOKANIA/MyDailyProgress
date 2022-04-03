package Zmq.Push_Pull;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class Pull {
    public static void main(String[] args) {
        try(ZContext context = new ZContext()){
            ZMQ.Socket socket = context.createSocket(SocketType.PULL);
            socket.connect("tcp://127.0.0.1:5555");
            String message = socket.recvStr();
            System.out.println(message);
        }
    }
}

