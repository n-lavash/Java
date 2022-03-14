package com.ssu.anastasia_levashkina.java.lesson2.task1.Fridge;

import com.ssu.anastasia_levashkina.java.lesson2.task1.Dishes.Dishes;
import com.ssu.anastasia_levashkina.java.lesson2.task1.Foods.Foods;

public interface Fridge {

    void addFoods(String type, int number);
    void addDish(String title, String description);
    Foods getFood(String type, String title);
    Dishes getDish(String title);
    Foods[] findFood();
    void sort(String option);
    void showAll(boolean dishes);
}
