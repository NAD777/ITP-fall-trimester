package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int foo, bar;
        Scanner scanner = new Scanner(System.in);
        foo = scanner.nextInt();
        bar = scanner.nextInt();
        System.out.format("%d %d\n", foo, bar);
        int tmp = foo;
        foo = bar;
        bar = tmp;
        System.out.format("Reversed:\n%d %d", foo, bar);
        scanner.close();
    }
}
