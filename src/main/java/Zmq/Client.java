package Zmq;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class Client {
    public static void main(String[] args) {
        try(ZContext context = new ZContext()){
            ZMQ.Socket socket = context.createSocket(SocketType.SUB);
            socket.connect("tcp://127.0.0.1:5555");
             socket.subscribe(ZMQ.SUBSCRIPTION_ALL);
            String response = socket.recvStr();
            socket.send("Hello bro");
            System.out.println(response);

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
