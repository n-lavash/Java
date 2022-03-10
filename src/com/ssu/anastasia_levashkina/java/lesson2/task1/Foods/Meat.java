package com.ssu.anastasia_levashkina.java.lesson2.task1.Foods;

public class Meat extends Foods {

    public Meat(String title, int weight) {
        super(title, weight);
    }

    @Override
    public String toString() {
        setAverageCalorie(112);
        return super.toString();
    }
}
