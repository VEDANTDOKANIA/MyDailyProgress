package MethodChaining;

public class MethodChaining {
    int age;
    int height;
    String name;
    public MethodChaining setAge(int age) {
        this.age = age;
        return this;
    }

    public MethodChaining setHeight(int height) {
        this.height = height;
        return this;
    }

    public MethodChaining setName(String name) {
        this.name = name;
        return this;
    }
    public MethodChaining display(){
        System.out.println("Age: "+age+" Height: "+height+" Name: "+name);
        return this;
    }

    public static void main(String[] args) {
        new MethodChaining().setAge(22).setName("Vedant").setHeight(6).display().display().display();
    }




}
