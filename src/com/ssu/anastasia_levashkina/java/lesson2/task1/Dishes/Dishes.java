package com.ssu.anastasia_levashkina.java.lesson2.task1.Dishes;

import com.ssu.anastasia_levashkina.java.lesson2.task1.Foods.Foods;

import java.util.Arrays;

public class Dishes {

    private String title;
    private String description;
    private Foods[] foods;

    public Dishes(String title, String description, Foods[] foods) {
        this.title = title;
        this.description = description;
        this.foods = foods;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Foods[] getFoods() {
        return foods;
    }

    public void setFoods(Foods[] foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        String s = "";
        for (Foods food:
             foods) {
            s+="\n\t" + food.toString();
        }
        return "Dishes:" +
                title +
                ". \nDescription: " + description +
                ".\nIngredients:" + s;
    }
}
