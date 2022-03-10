package com.ssu.anastasia_levashkina.java.lesson2.task1.Foods;

public class Vegetables extends Foods {

    public Vegetables(String title, int weight) {
        super(title, weight);
    }

    @Override
    public String toString() {
        setAverageCalorie(31);
        return super.toString();
    }
}
