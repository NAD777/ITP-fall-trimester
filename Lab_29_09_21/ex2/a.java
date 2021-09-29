package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float tempFar = scanner.nextFloat();
        System.out.print((tempFar - 32) * 5 / 9);
        scanner.close();
    }
}
