package com.ssu.anastasia_levashkina.java.lesson1.task1;

/**
 * Левашкина Анастасия.
 * Задача 1. Вариант 6. В массиве целых чисел вывести все элементы,
 *                      которые встречаются больше одного раза и индексы которых нечётные.
 */

public class ArrayApp {
    public static void main(String[] args) {
        ArrayApp app = new ArrayApp();
        app.countElements();
    }

    public int[] createArray() {
        int[] array = new int[20];

        // генерация элементов массива
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round((Math.random() * 20) - 10);
        }

        return array;
    }

    public void countElements() {
        int[] array = createArray();

        System.out.println("Array:");
        for (int j : array) System.out.print(j + " ");

        System.out.println();

        for (int i = 0; i < array.length; i+=2) {
            for (int j = i+2; j < array.length; j+=2) {
                if (array[i] == array[j]) {
                    System.out.print(array[i] + " ");
                }
            }
        }
    }
}
