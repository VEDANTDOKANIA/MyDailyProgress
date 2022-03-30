import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Server {
    public static void main(String[] args) {
        BufferedReader bufferedReader =null;
        BufferedWriter bufferedWriter = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Scanner scn = new Scanner(System.in);
        HashMap<String,String> hashMap = new HashMap<>();


        try{
            ServerSocket serverSocket = new ServerSocket(7777);

            while (!(serverSocket.isClosed())){
                Socket socket = serverSocket.accept();
                while (true) {
               /* bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));*/
                    dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    dataInputStream = new DataInputStream(socket.getInputStream());
                    System.out.println("Client Connected");
                    System.out.println("Enter key");
                    String key = scn.nextLine();
                    System.out.println("Enter Value");
                    String value = scn.nextLine();
                    hashMap.put(key, value);
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(hashMap);
                    objectOutputStream.flush();
                    byte[] bytes = byteArrayOutputStream.toByteArray();
                    System.out.println(bytes.length);
                    dataOutputStream.write(bytes);
                    dataOutputStream.flush();
                    dataInputStream.close();


                    System.out.println("Data Sent");

                    //dataOutputStream.close();
                    /*Gson  gson = new Gson();
                    String msgToSend = gson.toJson(hashMap);*/

                   /* bufferedWriter.write(msgToSend);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();*/

                   /* byte[] msgReceived;
                    dataInputStream.read();*/

                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(dataInputStream.readAllBytes()));
                    hashMap = (HashMap<String, String>) objectInputStream.readObject();
                    System.out.println(hashMap);

                  /*  String msg = new String(msgReceived, StandardCharsets.UTF_8);
                    System.out.println(msg);*/

                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}