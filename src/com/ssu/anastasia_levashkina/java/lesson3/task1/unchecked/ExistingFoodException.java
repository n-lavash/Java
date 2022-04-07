package com.ssu.anastasia_levashkina.java.lesson3.task1.unchecked;

// добавление одинаковой еды
public class ExistingFoodException extends RuntimeException {

    public ExistingFoodException(String message) {
        super(message);
    }
}
