package lesson4.task1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<T> implements Iterable<T>{
    T[] array;
    int number;

    public DynamicArray(Class<T> MyClass, int capacity) {
        array = (T[]) Array.newInstance(MyClass, capacity);
    }

    public DynamicArray(Class<T> MyClass) {
        int DefaultCapacity = 5;
        array = (T[]) Array.newInstance(MyClass, DefaultCapacity);
    }

    public void createArray() {
        int capacity = array.length * 2;
        T[] copyArray = Arrays.copyOf(array, capacity);
        try {
            for(int i = 0 ; i < array.length; i++){

                copyArray[i] = array[i];
            }
            array = copyArray;

        }
        catch (ArrayStoreException e){
            e.printStackTrace();

        }
    }

    public void add(T elem) {
        if(number + 1 == array.length){
           createArray();
        }

        array[number] = elem;
        number++;
    }

    public T get(int index) {
        return array[index];
    }

    public void set(T elem, int index) {
        T tmpElem = array[index];
        array[index] = elem;
        for(int i = index + 1 ; i < array.length;i++ ){
            T tmp = array[i];
            array[i] = tmpElem;
            tmpElem = tmp;
        }
        number++;
    }

    public void remove(int index) {
        array[index] = array[index+1];
        for(int i = index + 1 ; i < array.length - 1 ; i++) {
            array[i] = array[i+1];
        }
        number--;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");

        for (int i = 0; i < number; i++) {

            result.append(array[i]).append("[").append(i).append("] ");
        }
        return result + "\nnumber = " + number + "\n";
    }


    public class MyIterator implements Iterator<T> {

        int current = 0;

        @Override
        public boolean hasNext() {
            return number > current ;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[current++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }
}
