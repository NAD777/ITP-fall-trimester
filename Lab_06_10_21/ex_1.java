
package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s;
        s = scan.nextLine();
        String[] words = s.split(" ");
        if (words.length != 3) {
            System.out.print("Invalid input");
            System.exit(0);
        }
        float a = Float.parseFloat(words[0]);
        float b = Integer.parseInt(words[2]);
        if (words[1].equals("+")) {
            System.out.println(a + b);
            System.exit(0);
        }
        if (words[1].equals("*")) {
            System.out.println(a * b);
            System.exit(0);
        }
        if (words[1].equals("-")) {
            System.out.println(a - b);
            System.exit(0);
        }
        if (words[1].equals("/")) {
            if (b == 0) {
                System.out.println("-1");
            } else {
                System.out.println(a / b);
            }
        }
    }
}
