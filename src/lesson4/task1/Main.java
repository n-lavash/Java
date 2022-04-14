package lesson4.task1;

public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<>(Integer.class, 3);
        System.out.println("Проверка массива:");
        System.out.println(array);
        
        System.out.println("Добавляем элементы в конец массива:");
        array.add(9);
        array.add(8);
        array.add(7);
        System.out.println(array);
        array.add(6);
        array.add(5);
        System.out.println(array);

        System.out.println("Добавляем элемент в середину массива");
        array.set(100, 2);
        System.out.println(array);

        System.out.println("Удаление элемента:");
        array.remove(3);
        System.out.println(array);

        System.out.println("Получение элемента по индексу");
        System.out.println(array.get(4));

        System.out.println("\nПроверка работы foreach");
        for (Integer elem:
             array) {
            System.out.println(elem);
        }
        
    }
}
