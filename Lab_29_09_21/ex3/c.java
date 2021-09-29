package com.company;


import java.sql.Time;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        int max_el = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            max_el = Math.max(max_el, arr[i]);
        }
        int[] col = new int[max_el + 1];
        for(int i = 0; i < max_el + 1; i++){
            col[i] = 0;
        }

        for(int i = 0; i < n; i++){
            col[arr[i]] += 1;
        }

        for(int i = 0; i < max_el + 1; i++){
            if(col[i] > 1){
                System.out.format("%d ", i);
            }
        }
        scanner.close();
    }
}
