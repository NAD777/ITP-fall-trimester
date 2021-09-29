package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        if(a.length() != b.length()){
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        scanner.close();
    }
}
