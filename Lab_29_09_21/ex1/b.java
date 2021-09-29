package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        char inp;
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0);
        System.out.print((int) c);
        scanner.close();
    }
}
