package Zmq.Pub_Sub.ByteArray;

import com.google.gson.Gson;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Scanner;

public class Publish {
    public static void main(String[] args) {
        try(ZContext context = new ZContext()) {
            ZMQ.Socket socket = context.createSocket(SocketType.PUB);
            socket.bind("tcp://127.0.0.1:5553");
            Scanner scn = new Scanner(System.in);
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("1","vedant");
            hashMap.put("2","pruthvi");
            hashMap.put("3","smith");
            Gson gson = new Gson();
            String message =gson.toJson(hashMap);
            System.out.println("Enter Topic:");
            String topic = scn.next();
            String messageTosend= String.format(topic+message);
           byte[] arr = messageTosend.getBytes(StandardCharsets.UTF_8);
           socket.send(arr);
           Thread.sleep(1000);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
