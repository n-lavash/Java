package com.ssu.anastasia_levashkina.java.lesson3.task1;

import com.ssu.anastasia_levashkina.java.lesson2.task1.Fridge.Console;
import com.ssu.anastasia_levashkina.java.lesson3.task1.unchecked.ExistingFoodException;

import java.util.Scanner;

// добавление такого же объекта (2 исключения?) - непроверяемое
// проблемы с файлом (неправильное название) - проверяемое
// для продукта указано 0 калорий - непроверяемое
// создание еды, для которой не реализован класс (ягоды) - проверяемое

public class Main {
    public static void main(String[] args) {
        Console.openFridge();
    }
}
