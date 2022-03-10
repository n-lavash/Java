package com.ssu.anastasia_levashkina.java.lesson2.task1.Foods;

public class Foods {

    private String title;
    private int weight;
    private int averageCalorie;

    public Foods(String title, int weight) {
        this.title = title;
        this.weight = weight;
    }

    public String getTitle() {
        return title;
    }

    public int getWeight() {
        return weight;
    }

    public int getAverageCalorie() {
        return averageCalorie;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setAverageCalorie(int averageCalorie) {
        this.averageCalorie = averageCalorie;
    }

    public int calories(int calories) {
        return weight*calories/100;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ": " + getTitle() +
                ", weight - " + getWeight() + ", calories - " + calories(getAverageCalorie());
    }
}
