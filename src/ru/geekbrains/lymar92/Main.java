package ru.geekbrains.lymar92;



public class Main  {

    public static void main(String[] args) {
     ExampleClass example = new ExampleClass();
        new Thread(() -> example.printA()).start();
        new Thread(() -> example.printB()).start();
        new Thread(() -> example.printC()).start();


    }
}
