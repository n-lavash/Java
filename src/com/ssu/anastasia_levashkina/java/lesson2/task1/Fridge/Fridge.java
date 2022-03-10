package com.ssu.anastasia_levashkina.java.lesson2.task1.Fridge;

import com.ssu.anastasia_levashkina.java.lesson2.task1.Dishes.Dishes;
import com.ssu.anastasia_levashkina.java.lesson2.task1.Foods.Foods;

public interface Fridge {
    void addFood();
    void addDish();
    Foods getFood();
    Dishes getDish();
    Foods searchFood();
    Foods sortFoods();
}
