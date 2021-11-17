package com.company;


import java.io.*;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Will the following method compile? If not, why? No, because operator '>' is not implemented for T
public final class Algorithm {
    public static <T> T max(T x, T y) {
        return x > y ? x : y;
    }
}


class Main {
    // Will the following method compile? Yes, it will compile, all members of list are inherited or constitute of class Numbers
    public static void print(List<? extends Number> list) {
        for (Number n : list) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}


// methods should be not static
public class Singleton<T> {

    public static T getInstance() {
        if (instance == null) {
            instance = new Singleton<T>();
        }
        return instance;
    }

    private static T instance = null;
}

// Yes, because Node implements Comparable, upcasting here
class Node<T> implements Comparable<T> {
    public int compareTo(T obj) {
        return 1;
    }

    // ...
    public void asd() {
        Node<String> node = new Node<>();
        Comparable<String> comp = node;
    }
}
