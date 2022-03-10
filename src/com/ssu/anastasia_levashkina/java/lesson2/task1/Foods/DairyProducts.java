package com.ssu.anastasia_levashkina.java.lesson2.task1.Foods;

public class DairyProducts extends Foods {

    private boolean sour;

    public DairyProducts(String title, int weight, boolean sour) {
        super(title, weight);
        this.sour = sour;
    }

    public boolean isSour() {
        return sour;
    }

    public void setSour(boolean sour) {
        this.sour = sour;
    }

    @Override
    public String toString() {
        setAverageCalorie(94);
        return super.toString() +
                "sour - " + (isSour() ? "yes" : "no");
    }
}
