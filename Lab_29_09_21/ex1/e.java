package com.company;

import java.util.Scanner;

public class Main {
    private static int count_vowels(String s) {
        String s_upper = "AEIOUY";
        String s_lower = "aeiouy";
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s_lower.indexOf(s.charAt(i)) != -1) {
                cnt += 1;
            }
            if (s_upper.indexOf(s.charAt(i)) != -1) {
                cnt += 1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inp = scanner.nextLine();
        System.out.print(count_vowels(inp));
    }
}
