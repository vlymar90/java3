package ru.geekbrains.lymar92;


import java.util.ArrayList;
import java.util.Arrays;

public class Main <T> {
    T[] list;

    public Main(T... list) {
        this.list = list;
    }

    public T[] getList() {
        return list;
    }

    public void changeArrays(T[] list) {
        if (list != null && list.length <= 4) {
            T t = list[3];
            list[3] = list[1];
            list[1] = t;
        } else {
            System.out.println("Ошибка параметров");
        }
    }
        public ArrayList<T> createArrayList(T[] list) {
        ArrayList<T> arr = new ArrayList(Arrays.asList(list));
        return arr;
    }

    @Override
    public String toString() {
        String info = "";
        for(T t : list) {
            info += t + " ";
        }
        return info;
    }

    public static void main(String[] args) {

        Apple[] apples = {new Apple(), new Apple(), new Apple()};
        Orange[] oranges = {new Orange(), new Orange()};
        Box<Apple> boxApples = new Box<>(new ArrayList<>(Arrays.asList(apples)));
        Box<Orange> boxOrange = new Box<>(new ArrayList<>(Arrays.asList(oranges)));
        Box<Apple> newBoxApples = new Box<>(new ArrayList<>());

        //Test
        System.out.println(boxApples.compare(boxOrange));
//        boxApples.add(apples[0]);
//        boxApples.shift(newBoxApples.getList());
//        System.out.println(newBoxApples.getList());
//        System.out.println(boxApples.getList());

    }
}
