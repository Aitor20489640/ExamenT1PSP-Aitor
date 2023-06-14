package Ejercicio02;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeList {
    private final List<String> list;

    ThreadSafeList() {
        list = new ArrayList<String>();
    }

    synchronized void add(String s) {
        list.add(s);
    }

    String get(int index) {
        return list.get(index);
    }

    int size() {
        return list.size();
    }

    void forEach() {
        list.forEach(System.out::println);
    }
}
