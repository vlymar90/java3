package ru.geekbrains.lymar92;

public class ExampleClass {
   private volatile char value = 'A';
  private final Object block = new Object();
    public  void printA() {
        try {
            synchronized (block) {
                for (int i = 0; i < 5; i++) {
                    while (value != 'A') {
                        block.wait();
                    }

                    System.out.print(value);
                    value = 'B';
                    block.notifyAll();
                }
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printB() {
        try {
            synchronized (block) {
                for (int i = 0; i < 5; i++) {
                    while (value != 'B') {
                        block.wait();
                    }

                    System.out.print(value);
                    value = 'C';
                    block.notifyAll();
                }
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printC() {
        try {
            synchronized (block) {
                for (int i = 0; i < 5; i++) {
                    while (value != 'C') {
                        block.wait();
                    }

                    System.out.print(value);
                    value = 'A';
                    block.notifyAll();
                }
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
