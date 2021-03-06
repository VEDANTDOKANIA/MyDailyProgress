import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;


public class Client {
    public static void sum(){
        System.out.println("Hello");
    }


    public static void main(String[] args) {
        Client client = null;
        client.sum();
        Scanner scn = new Scanner(System.in);
        ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream=null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        DataInputStream dataInputStream=null;
        BufferedWriter bufferedWriter =null;
        BufferedReader bufferedReader = null;
        HashMap<String,String> hashMap = new HashMap<>();


        try{
            Socket socket = new Socket("localhost",7777);
            while (true){
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            dataInputStream = new DataInputStream(socket.getInputStream());
            System.out.println("I am here");
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(dataInputStream.readAllBytes()));


                hashMap= (HashMap<String, String>) objectInputStream.readObject();
                System.out.println(hashMap);

                System.out.println("Enter key");
                String key = scn.nextLine();
                System.out.println("Enter Value");
                String value = scn.nextLine();
                hashMap.put(key,value);
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(hashMap);
                objectOutputStream.flush();
                objectOutputStream.close();
                byte[] bytes = byteArrayOutputStream.toByteArray();
            System.out.println(bytes.length);
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.write(bytes);
                dataOutputStream.flush();




               /* Gson gson = new Gson();
                String msgToSend = gson.toJson(hashMap);*/
               /* bufferedWriter.write(bytes);
                bufferedWriter.newLine();
                bufferedWriter.flush();*/
                /*output = bufferedReader.readLine();
                System.out.println(output);*/


        }
        }
        catch (Exception e ){
            System.out.println(e.getMessage());
        }

    }
}