package org.example.myList;

import java.util.Comparator;
import java.util.List;

public class MyArrayList<T> implements MyList<T> {
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    public void add(T item) {
        if(pointer == array.length-1)
            resize(array.length*2);
        array[pointer++] = item;
    }

    public void add(T item, int index) {
        if (index < 0 || index > pointer) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + pointer);
        }

        if (pointer == array.length - 1) {
            resize(array.length * 2);
        }

        System.arraycopy(array, index, array, index + 1, pointer - index);
        array[index] = item;
        pointer++;
    }
    public T get(int index) {
        return (T) array[index];
    }
    public void remove(int index) {

        for (int i = index; i<pointer; i++)
            array[i] = array[i+1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length/2);
    }
    public void remove(T item) {
        if (item == null) {
            for (int i = 0; i < pointer; i++) {
                if (array[i] == null) {
                    remove(i);
                    return;
                }
            }
        } else {
            for (int i = 0; i < pointer; i++) {
                if (item.equals(array[i])) {
                    remove(i);
                    return;
                }
            }
        }
    }

    public void removeAll(){
        array = new Object[INIT_SIZE];
        pointer = 0;
    }
    public int size() {
        return pointer;
    }

    /*Вспомогательный метод для масштабирования.*/
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}
