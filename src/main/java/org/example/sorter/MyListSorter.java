package org.example.sorter;

import org.example.myList.MyList;

public class MyListSorter {
    public static <T extends Comparable<T>> void sort(MyList<T> list) {
        if (list.size() <= 1) {
            return;
        }
        // Создаем временный массив для сортировки
        T[] tempArray = (T[]) new Comparable[list.size()];
        // Копируем элементы из списка во временный массив
        for (int i = 0; i < list.size(); i++) {
            tempArray[i] = list.get(i);
        }
        // Вызываем вспомогательный метод для сортировки слиянием
        mergeSort(tempArray, 0, tempArray.length - 1);
        // Копируем отсортированные элементы из временного массива обратно в список
        list.removeAll();
        for (int i = 0; i < tempArray.length; i++) {
            list.add(tempArray[i], i);
        }
    }

    private static <T extends Comparable<T>> void mergeSort(T[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] array, int left, int middle, int right) {

        T[] leftArray = (T[]) new Comparable[middle - left + 1];
        T[] rightArray = (T[]) new Comparable[right - middle];


        for (int i = 0; i < leftArray.length; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < rightArray.length; ++j) {
            rightArray[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[left] = leftArray[i];
                i++;
            } else {
                array[left] = rightArray[j];
                j++;
            }
            left++;
        }

        while (i < leftArray.length) {
            array[left] = leftArray[i];
            i++;
            left++;
        }

        while (j < rightArray.length) {
            array[left] = rightArray[j];
            j++;
            left++;
        }


    }
}
