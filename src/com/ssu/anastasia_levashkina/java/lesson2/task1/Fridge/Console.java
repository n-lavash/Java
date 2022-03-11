package com.ssu.anastasia_levashkina.java.lesson2.task1.Fridge;

import com.ssu.anastasia_levashkina.java.lesson2.task1.Dishes.Dishes;
import com.ssu.anastasia_levashkina.java.lesson2.task1.Foods.Foods;

import java.util.Scanner;

public class Console implements Fridge {

    public static void openFridge() {
        Scanner scanner = new Scanner(System.in);
        Foods[] fruits;
        Foods[] meats;
        Foods[] vegetables;
        Foods[] dairyProducts;

        System.out.println("\nChoose action:" +
                "\n\t1 - add food" +
                "\n\t2 - add dish" +
                "\n\t3 - get food" +
                "\n\t4 - get dish" +
                "\n\t5 - find food" +
                "\n\t6 - sort" +
                "\n\t0 - exit");

        while (true) {
            String action = scanner.nextLine();

            switch (action) {
                case "1":
                    System.out.println("Choose type of food:" +
                            "\n\t1 - Fruit" +
                            "\n\t2 - Meat" +
                            "\n\t3 - Vegetable" +
                            "\n\t4 - Dairy product");
                    String type = scanner.nextLine();
                    switch (type) {

                    }
            }
        }
    }

    @Override
    public void addFood() {

    }

    @Override
    public void addDish() {

    }

    @Override
    public Foods getFood() {
        return null;
    }

    @Override
    public Dishes getDish() {
        return null;
    }

    @Override
    public Foods searchFood() {
        return null;
    }

    @Override
    public Foods sortFoods() {
        return null;
    }
}
