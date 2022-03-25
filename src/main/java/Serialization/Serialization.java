package Serialization;

import java.io.*;

public class Serialization implements Serializable {
    public static class Student implements Serializable{
        public int age;
        transient int height;

        public Student(int age, int height) {
            this.age = age;
            this.height = height;
        }
    }

    public static void main(String[] args) throws Exception {
        Student s1 = new Student(1,2);
        File file = new File("/home/vedant/JunitMaven/src/main/java/serial.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
       ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
       objectOutputStream.writeObject(s1);
        objectOutputStream.flush();
        objectOutputStream.close();
       ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
      Student s2 = (Student) objectInputStream.readObject();
        System.out.println(s2.age+""+s2.height);
    }
}
