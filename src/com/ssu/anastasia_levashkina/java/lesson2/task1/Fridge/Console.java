package com.ssu.anastasia_levashkina.java.lesson2.task1.Fridge;

import com.ssu.anastasia_levashkina.java.lesson2.task1.Dishes.Dishes;
import com.ssu.anastasia_levashkina.java.lesson2.task1.Foods.*;
import com.ssu.anastasia_levashkina.java.lesson3.task1.checked.InvalidFilenameException;
import com.ssu.anastasia_levashkina.java.lesson3.task1.unchecked.ExistingFoodException;
import com.ssu.anastasia_levashkina.java.lesson3.task1.unchecked.FoodWeightException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Console {

    private static Foods[] foodsOnDish = new Foods[100];
    private static Dishes[] allDishes = new Dishes[100];
    static int j = 0;
    static int k = 0;

    public static void openFridge() {
        Scanner scanner = new Scanner(System.in);
        String type;
        String title;

        Console console = new Console();

        while (true) {
            System.out.println("\nChoose action:" +
                    "\n\t1 - add food" +
                    "\n\t2 - add dish" +
                    "\n\t3 - get food" +
                    "\n\t4 - get dish" +
                    "\n\t5 - find food" +
                    "\n\t6 - sort" +
                    "\n\t7 - show all" +
                    "\n\t8 - open file" +
                    "\n\t0 - exit");
            String action = scanner.nextLine();

            switch (action) {
                case "1":
                    System.out.println("Which type of foods do you want to add?" +
                            "\n\t1 - Fruit" +
                            "\n\t2 - Meat" +
                            "\n\t3 - Vegetable" +
                            "\n\t4 - Dairy product");
                    type = scanner.nextLine();
                    while (true) {
                        if (type.equals("1") || type.equals("2") || type.equals("3") || type.equals("4")) break;
                        else System.out.println("Invalid value. Try again" +
                                "\nWhich type of foods do you want to add?" +
                                "\n\t1 - Fruit" +
                                "\n\t2 - Meat" +
                                "\n\t3 - Vegetable" +
                                "\n\t4 - Dairy product");
                        type = scanner.nextLine();
                    }
                    System.out.println("Enter number of foods:");
                    int number = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        addFoods(type, number);
                    } catch (ExistingFoodException | FoodWeightException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("Enter the title of the dish:");
                    title = scanner.nextLine();
                    System.out.println("Enter a description of the dish:");
                    String description = scanner.nextLine();
                    addDish(title, description);
                    break;
                case "3":
                    System.out.println("Choose type of food:" +
                            "\n\t1 - Fruit" +
                            "\n\t2 - Meat" +
                            "\n\t3 - Vegetable" +
                            "\n\t4 - Dairy product");
                    type = scanner.nextLine();
                    System.out.println("Enter the title of the food:");
                    title = scanner.nextLine();
                    if (!Objects.isNull(getFood(type, title))) System.out.println(getFood(type, title));
                    else System.out.println("This product is not in the fridge.");
                    break;
                case "4":
                    System.out.println("Enter the title of the dish:");
                    title = scanner.nextLine();
                    if (Objects.nonNull(getDish(title))) System.out.println(getDish(title));
                    else System.out.println("This dish is not in the fridge.");
                    break;
                case "5":
                    Foods[] foods = findFood();
                    if (Objects.nonNull(foods)) {
                        for (Foods food :
                                foods) {
                            System.out.println(food);
                        }
                    } else System.out.println("You don't have any foods");
                    break;
                case "6":
                    while (true) {
                        System.out.println("Choose which option to sort by:" +
                                "\n\t1 - title" +
                                "\n\t2 - weight" +
                                "\n\t3 - calorie");
                        String option = scanner.nextLine();
                        if (option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4")) {
                            sort(option);
                            break;
                        } else System.out.println("Invalid value. Try again");
                    }
                    break;
                case "7":
                    System.out.println("Show dishes? (yes/no)");
                    String dishes = scanner.nextLine();
                    if (dishes.equalsIgnoreCase("yes")) showAll(true);
                    else showAll(false);
                    break;
                case "8":
                    try {
                        fileWork();
                    } catch (InvalidFilenameException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid value. Try again");
            }
        }
    }

    private static void fileWork() throws InvalidFilenameException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name");
        String fileName = scanner.nextLine();
        File file = new File("C://" + fileName);
        if (!file.exists()) {
            throw new InvalidFilenameException("?????????????????????? ???????????????? ??????????");
        }

        System.out.println("???????????????? ??????????: " + file.getName());
        System.out.println("???????? ???? ??????????: " + file.getPath());
    }

    public static void addFoods(String type, int number) throws ExistingFoodException, FoodWeightException {
        Scanner scanner = new Scanner(System.in);

        String title;
        int weight;

        switch (type) {
            case "1":

                for (int i = k; i < k+number; i++) {
                    System.out.println("Enter name of the food:");
                    title = scanner.nextLine();
                    if (Objects.nonNull(foodsOnDish[0]))
                        if (Objects.nonNull(getFood("1", title))) {
                            throw new ExistingFoodException("?????????? ?????? ?????? ???????? ?? ????????????????????????");
                        }

                    System.out.println("Enter weight in grams:");
                    weight = scanner.nextInt();
                    if (weight <= 0) {
                        throw new FoodWeightException("?????????????? ???????????? ?????? ??????");
                    }
                    scanner.nextLine();

                    System.out.println("Fruit sugary? (yes/no)");
                    String sugar = scanner.nextLine();
                    foodsOnDish[i] = new Fruits(title, weight, sugar.equalsIgnoreCase("yes"));
                }

                break;
            case "2":

                for (int i = k; i < k+number; i++) {
                    System.out.println("Enter name of the food:");
                    title = scanner.nextLine();
                    scanner.nextLine();

                    if (Objects.nonNull(foodsOnDish[0]))
                        if (Objects.nonNull(getFood("2", title))) {
                            throw new ExistingFoodException("?????????? ?????? ?????? ???????? ?? ????????????????????????");
                        }

                    System.out.println("Enter weight in grams:");
                    weight = scanner.nextInt();
                    if (weight <= 0) {
                        throw new FoodWeightException("?????????????? ???????????? ?????? ??????");
                    }
                    scanner.nextLine();

                    foodsOnDish[i] = new Meat(title, weight);
                }
                break;
            case "3":

                for (int i = k; i < k+number; i++) {
                    System.out.println("Enter name of the food:");
                    title = scanner.nextLine();

                    if (Objects.nonNull(foodsOnDish[0]))
                        if (Objects.nonNull(getFood("3", title))) {
                            throw new ExistingFoodException("?????????? ?????? ?????? ???????? ?? ????????????????????????");
                        }

                    System.out.println("Enter weight in grams:");
                    weight = scanner.nextInt();
                    if (weight <= 0) {
                        throw new FoodWeightException("?????????????? ???????????? ?????? ??????");
                    }
                    scanner.nextLine();

                    foodsOnDish[i] = new Vegetables(title, weight);
                }
                break;
            case "4":

                for (int i = k; i < k+number; i++) {
                    System.out.println("Enter name of the food:");
                    title = scanner.nextLine();

                    if (Objects.nonNull(foodsOnDish[0]))
                        if (Objects.nonNull(getFood("4", title))) {
                            throw new ExistingFoodException("?????????? ?????? ?????? ???????? ?? ????????????????????????");
                        }

                    System.out.println("Enter weight in grams:");
                    weight = scanner.nextInt();
                    if (weight <= 0) {
                        throw new FoodWeightException("?????????????? ???????????? ?????? ??????");
                    }
                    scanner.nextLine();

                    System.out.println("Food sour? (yes/no)");
                    Scanner scanner1 = new Scanner(System.in);
                    String sour = scanner1.nextLine();

                    foodsOnDish[i] = new DairyProducts(title, weight, sour.equalsIgnoreCase("yes"));
                }
                break;
        }
        k += number;
    }

    public static void addDish(String titleDish, String description) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many foods are in a dish?");
        int number = scanner.nextInt();
        scanner.nextLine();
        foodsOnDish = new Foods[number];

        for (int i = 0; i < number; i++) {
            while (true) {
                System.out.println("\nChoose type of food: " +
                        "\n\t1 - Fruit" +
                        "\n\t2 - Meat" +
                        "\n\t3 - Vegetable" +
                        "\n\t4 - Dairy product");
                String type = scanner.nextLine();
                System.out.println("What ingredients does the dish consist of?");
                String food = scanner.nextLine();
                if (Objects.nonNull(getFood(type, food))) {
                    foodsOnDish[i] = getFood(type, food);
                    break;
                } else System.out.println("This product is not in the fridge. Choose another food.");
            }
        }

        allDishes[j] = new Dishes(titleDish, description, foodsOnDish);
        j++;
    }

    public static Foods getFood(String type, String title) {
        try {
            for (Foods foods :
                    foodsOnDish) {
                if (title.equalsIgnoreCase(foods.getTitle())) {
                    Fruits s = (Fruits) foods;
                    return new Fruits(title, foods.getWeight(), s.isSugary());
                }
            }
        } catch (Exception e) {
            System.out.println("You don't have any fruits :(");
        }

        return null;
    }

    public static Dishes getDish(String title) {
        try {
            for (Dishes dish :
                    allDishes) {
                if (title.equalsIgnoreCase(dish.getTitle())) {
                    return new Dishes(title, dish.getDescription(), dish.getFoods());
                }
            }
        } catch (Exception e) {
            System.out.println("You don't have any dishes");
        }
        return null;
    }

    public static Foods[] findFood() {
        if (Objects.isNull(foodsOnDish))
            return null;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Filter:\nClick \"Enter\" if you do not want to use this filter");
        System.out.println("Enter the type of foods:" +
                "\n\t1 - Fruit" +
                "\n\t2 - Meat" +
                "\n\t3 - Vegetable" +
                "\n\t4 - Dairy product");
        String type = scanner.nextLine();

        System.out.println("Enter weight range of foods\nFrom:");
        String weightFrom = scanner.nextLine();
        int fromW = 0;
        System.out.println("To:");
        String weightTo = scanner.nextLine();
        int toW = Integer.MAX_VALUE;

        System.out.println("Enter calorie range of food\nFrom:");
        String calorieFrom = scanner.nextLine();
        int fromC = 0;
        System.out.println("To:");
        String calorieTo = scanner.nextLine();
        int toC = Integer.MAX_VALUE;

        if (!weightFrom.equals("")) {
            fromW = Integer.parseInt(weightFrom);
        }
        if (!weightTo.equals("")) {
            toW = Integer.parseInt(weightTo);
        }
        if (!calorieFrom.equals("")) {
            fromC = Integer.parseInt(calorieFrom);
        }
        if (!calorieTo.equals("")) {
            toC = Integer.parseInt(calorieTo);
        }

        int n = 0;
        if (Objects.nonNull(foodsOnDish)) {
            n += k;
        }

        Foods[] findFoods = new Foods[n];
        int i = 0;

        if (!type.equals("")) {
            switch (type) {
                case "1":
                    if (Objects.nonNull(foodsOnDish)) {
                        System.out.println("Food is sugary? (yes/no)");
                        String sugary = scanner.nextLine();
                        boolean sugar = true;
                        if (sugary.equalsIgnoreCase("yes")) sugar = true;
                        else if (sugary.equalsIgnoreCase("no")) sugar = false;
                        for (Foods food :
                                foodsOnDish) {
                            if (food.getClass().getSimpleName().equalsIgnoreCase("Fruits")) {
                                if (food.getWeight() >= fromW && food.getWeight() <= toW &&
                                        food.calories(food.getAverageCalorie()) >= fromC && food.calories(food.getAverageCalorie()) <= toC) {
                                    Fruits f = (Fruits) food;
                                    if (!sugary.equals("")) {
                                        if (f.isSugary() == sugar) {
                                            findFoods[i] = new Fruits(food.getTitle(), food.getWeight(), sugar);
                                            i++;
                                        }
                                    } else {
                                        findFoods[i] = new Fruits(food.getTitle(), food.getWeight(), f.isSugary());
                                        i++;
                                    }
                                }
                            }
                        }
                    } else System.out.println("You don't have any fruits.");
                    break;
                case "2":
                    if (Objects.nonNull(foodsOnDish)) {
                        for (Foods food :
                                foodsOnDish) {
                            if (food.getClass().getSimpleName().equalsIgnoreCase("Meat")) {
                                if (food.getWeight() >= fromW && food.getWeight() <= toW &&
                                        food.calories(food.getAverageCalorie()) >= fromC && food.calories(food.getAverageCalorie()) <= toC) {
                                    findFoods[i] = new Meat(food.getTitle(), food.getWeight());
                                    i++;
                                }
                            }
                        }
                    } else System.out.println("You don't have any meats.");
                    break;
                case "3":
                    if (Objects.nonNull(foodsOnDish)) {
                        for (Foods food :
                                foodsOnDish) {
                            if (food.getClass().getSimpleName().equalsIgnoreCase("Vegetables")) {
                                if (food.getWeight() >= fromW && food.getWeight() <= toW &&
                                        food.calories(food.getAverageCalorie()) >= fromC && food.calories(food.getAverageCalorie()) <= toC) {
                                    findFoods[i] = new Meat(food.getTitle(), food.getWeight());
                                    i++;
                                }
                            }
                        }
                    } else System.out.println("You don't have any vegetables.");
                    break;
                case "4":
                    if (Objects.nonNull(foodsOnDish)) {
                        System.out.println("Food is sour? (yes/no)");
                        String sours = scanner.nextLine();
                        boolean sour = true;
                        if (sours.equalsIgnoreCase("yes")) sour = true;
                        else if (sours.equalsIgnoreCase("no")) sour = false;
                        for (Foods food :
                                foodsOnDish) {
                            if (food.getClass().getSimpleName().equalsIgnoreCase("DairyProducts")) {
                                if (food.getWeight() >= fromW && food.getWeight() <= toW &&
                                        food.calories(food.getAverageCalorie()) >= fromC && food.calories(food.getAverageCalorie()) <= toC) {
                                    DairyProducts f = (DairyProducts) food;
                                    if (!sours.equals("")) {
                                        if (f.isSour() == sour) {
                                            findFoods[i] = new Fruits(food.getTitle(), food.getWeight(), sour);
                                            i++;
                                        }
                                    } else {
                                        findFoods[i] = new Fruits(food.getTitle(), food.getWeight(), f.isSour());
                                        i++;
                                    }
                                }
                            }
                        }
                    } else System.out.println("You don't have any dairy products.");
                    break;
            }
        } else {
            if (Objects.nonNull(foodsOnDish)) {
                System.out.println("Food is sugary? (yes/no)");
                String sugary = scanner.nextLine();
                boolean sugar = true;
                if (sugary.equalsIgnoreCase("yes")) sugar = true;
                else if (sugary.equalsIgnoreCase("no")) sugar = false;
                for (Foods food :
                        foodsOnDish) {
                    if (food.getClass().getSimpleName().equalsIgnoreCase("Fruits")) {
                        if (food.getWeight() >= fromW && food.getWeight() <= toW &&
                                food.calories(food.getAverageCalorie()) >= fromC && food.calories(food.getAverageCalorie()) <= toC) {
                            Fruits f = (Fruits) food;
                            if (!sugary.equals("")) {
                                if (f.isSugary() == sugar) {
                                    findFoods[i] = new Fruits(food.getTitle(), food.getWeight(), sugar);
                                    i++;
                                }
                            } else {
                                findFoods[i] = new Fruits(food.getTitle(), food.getWeight(), f.isSugary());
                                i++;
                            }
                        }
                    }
                }
            } else System.out.println("You don't have any fruits.");
            if (Objects.nonNull(foodsOnDish)) {
                for (Foods food :
                        foodsOnDish) {
                    if (food.getClass().getSimpleName().equalsIgnoreCase("Meat")) {
                        if (food.getWeight() >= fromW && food.getWeight() <= toW &&
                                food.calories(food.getAverageCalorie()) >= fromC && food.calories(food.getAverageCalorie()) <= toC) {
                            findFoods[i] = new Meat(food.getTitle(), food.getWeight());
                            i++;
                        }
                    }
                }
            } else System.out.println("You don't have any meats.");
            if (Objects.nonNull(foodsOnDish)) {
                for (Foods food :
                        foodsOnDish) {
                    if (food.getClass().getSimpleName().equalsIgnoreCase("Vegetables")) {
                        if (food.getWeight() >= fromW && food.getWeight() <= toW &&
                                food.calories(food.getAverageCalorie()) >= fromC && food.calories(food.getAverageCalorie()) <= toC) {
                            findFoods[i] = new Meat(food.getTitle(), food.getWeight());
                            i++;
                        }
                    }
                }
            } else System.out.println("You don't have any vegetables.");
            if (Objects.nonNull(foodsOnDish)) {
                System.out.println("Food is sour? (yes/no)");
                String sours = scanner.nextLine();
                boolean sour = true;
                if (sours.equalsIgnoreCase("yes")) sour = true;
                else if (sours.equalsIgnoreCase("no")) sour = false;
                for (Foods food :
                        foodsOnDish) {
                    if (food.getClass().getSimpleName().equalsIgnoreCase("DairyProducts")) {
                        if (food.getWeight() >= fromW && food.getWeight() <= toW &&
                                food.calories(food.getAverageCalorie()) >= fromC && food.calories(food.getAverageCalorie()) <= toC) {
                            DairyProducts f = (DairyProducts) food;
                            if (!sours.equals("")) {
                                if (f.isSour() == sour) {
                                    findFoods[i] = new Fruits(food.getTitle(), food.getWeight(), sour);
                                    i++;
                                }
                            } else {
                                findFoods[i] = new Fruits(food.getTitle(), food.getWeight(), f.isSour());
                                i++;
                            }
                        }
                    }
                }
            } else System.out.println("You don't have any dairy products.");

        }
        return findFoods;
    }

    public static void sort(String option) {

        switch (option) {
            case "1":
                Comparator<Foods> comparator1 = new Comparator<Foods>() {
                    @Override
                    public int compare(Foods o1, Foods o2) {
                        return o1.getTitle().compareTo(o2.getTitle());
                    }
                };
                Comparator<Dishes> comparator12 = new Comparator<Dishes>() {
                    @Override
                    public int compare(Dishes o1, Dishes o2) {
                        return o1.getTitle().compareTo(o2.getTitle());
                    }
                };
                try {
                    Arrays.sort(foodsOnDish, comparator1);
                } catch (Exception e) {
                    System.out.println("You don't have any fruits, so we can't sort it");
                }

                try {
                    Arrays.sort(allDishes, comparator12);
                } catch (Exception e) {
                    System.out.println("You don't have any dishes, so we can't sort it");
                }

                showAll(true);
                break;
            case "2":
                Comparator<Foods> comparator2 = new Comparator<Foods>() {
                    @Override
                    public int compare(Foods o1, Foods o2) {
                        if (o1.getWeight() > o2.getWeight()) {
                            return -1;
                        } else if (o1.getWeight() < o2.getWeight()) {
                            return 1;
                        } else return 0;
                    }
                };

                try {
                    Arrays.sort(foodsOnDish, comparator2);
                } catch (Exception e) {
                    System.out.println("You don't have any fruits, so we can't sort it");
                }
                showAll(false);
                break;

            case "3":
                Comparator<Foods> comparator3 = new Comparator<Foods>() {
                    @Override
                    public int compare(Foods o1, Foods o2) {
                        if (o1.calories(o1.getAverageCalorie()) > o2.calories(o2.getAverageCalorie())) {
                            return -1;
                        } else if (o1.calories(o1.getAverageCalorie()) < o2.calories(o2.getAverageCalorie())) {
                            return 1;
                        } else return 0;
                    }
                };

                try {
                    Arrays.sort(foodsOnDish, comparator3);
                } catch (Exception e) {
                    System.out.println("You don't have any fruits, so we can't sort it");
                }
                showAll(false);
                break;
        }
    }

    public static void showAll(boolean showDishes) {
        boolean check = false;
        for (Foods foods :
                foodsOnDish) {
            try {
                if (Objects.nonNull(foods))
                    System.out.println(foods);
                check = true;
            } catch (Exception e) {
            }
        }

        if (!check) {
            System.out.println("You don't have any foods :((");
        }

        if (showDishes) {
            System.out.println("\nDishes:");
            check = false;
            for (Dishes dishes :
                    allDishes) {
                try {
                    if (Objects.nonNull(dishes.getFoods()))
                        System.out.println(dishes);
                    check = true;
                } catch (Exception e) {

                }
            }

            if (!check) {
                System.out.println("You don't have any dishes :((");
            }

        }
    }
}