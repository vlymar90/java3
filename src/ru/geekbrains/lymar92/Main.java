package ru.geekbrains.lymar92;

public class Main {
    public static void main(String[] args) {
        try {
            ClassStart.start(new TestClass().getClass());
        }
         catch (RuntimeException e) {
             System.out.println(e.getMessage());
             System.exit(0);
        }
    }
}
