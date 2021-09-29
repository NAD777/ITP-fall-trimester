
package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0);
        if ('a' <= c && c <= 'z') {
            System.out.print(c - 'a' + 1);
        } else if ('A' <= c && c <= 'Z') {
            System.out.print(c - 'A' + 1);
        } else {
            System.out.print("Invalid input!");
        }
        scanner.close();
    }
}
