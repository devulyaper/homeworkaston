package org.example;

import org.example.myList.MyArrayList;
import org.example.myList.MyList;
import org.example.sorter.MyListSorter;

public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>();
        list.add("z");
        list.add("c");
        list.add("j");
        list.add("b");
        MyListSorter.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}