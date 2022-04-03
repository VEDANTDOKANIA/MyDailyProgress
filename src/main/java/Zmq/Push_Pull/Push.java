package Zmq.Push_Pull;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class Push {
    public static void main(String[] args) {
        try(ZContext context = new ZContext()){
            ZMQ.Socket socket = context.createSocket(SocketType.PUSH);
            socket.bind("tcp://127.0.0.1:5555");
            while(true){
            socket.send("Hello");
            Thread.sleep(1000);
                System.out.println("done");}


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
