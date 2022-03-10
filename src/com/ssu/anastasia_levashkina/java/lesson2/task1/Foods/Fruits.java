package com.ssu.anastasia_levashkina.java.lesson2.task1.Foods;

public class Fruits extends Foods {

    private boolean sugary;

    public Fruits(String title, int weight, boolean sugary) {
        super(title, weight);
        this.sugary = sugary;
    }

    public void setSugary(boolean sugary) {
        this.sugary = sugary;
    }

    public boolean isSugary() {
        return sugary;
    }

    @Override
    public String toString() {
        setAverageCalorie(56);
        return super.toString() +
                ", sugary - " + (isSugary() ? "yes" : "no");
    }
}
