package ru.geekbrains.lymar92;

import java.util.ArrayList;

public class Box <T extends Fruit> {

   private ArrayList<T> list;

   public Box(ArrayList<T> list) {
        this.list = list;
    }

    public void add(T t) {
        list.add(t);
    }

    public ArrayList<T> getList() {
        return list;
    }

    public boolean compare(Box<?> another) {
        if(this.getWeightTotal() == another.getWeightTotal()) {
            return true;
        }
        else {
            return false;
        }
    }

    public double getWeightTotal() {
        double sum = this.list.get(0).getWeight() * list.size();
        return sum;
    }

    public void shift(ArrayList<T> newBox) {
       newBox.addAll(this.list);
       list.clear();
    }
}
