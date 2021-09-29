package com.company;


import java.sql.Time;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        if (sum == 0 || n == 0) {
            System.out.print("Invalid data!");
        } else {
            System.out.print(sum / n);
        }
        scanner.close();
    }
}
