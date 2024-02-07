package org.example.myList;

import java.util.Objects;

public class MyArrayList<T> implements MyList<T> {
    private static final int INIT_SIZE = 16;
    private static final int CUT_RATE = 4;
    public static final String OUT_OF_BOUND_ERR_MSG = "Index: %d, Size: %d";
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    public void add(T item) {
        if(pointer == array.length-1)
            resize(array.length*2);
        array[pointer++] = item;
    }

    public void add(T item, int index) {
        if (index < 0 || index > pointer) {
            throw new IndexOutOfBoundsException(String.format(OUT_OF_BOUND_ERR_MSG, index, pointer));// вот такое форматирование лучше + строки сообщения всегда выносим в статические константы
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

        for (int i = index; i<pointer; i++) { // {} - не забывай про них, они улучшают читаемосить
            array[i] = array[i+1];
        }
        array[pointer] = null;
        pointer--;
        if (resizeNeeded()) {// если предикат сложный, его лучше вынести в отдельный метод
            resize(array.length/2);
        }
    }

    private boolean resizeNeeded() { // просто как пример, нейминг можно и улучшить)
        return array.length > INIT_SIZE && pointer < array.length / CUT_RATE;
    }

    public void remove(T item) {
        for (int i = 0; i < pointer; i++) {
            if (Objects.equals(item, array[i])) {
                remove(i);
                return;
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
