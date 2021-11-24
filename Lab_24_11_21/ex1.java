package com.company;

import java.io.*;


class Stack {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[]{1, 2, 3, -1, -6};
        Operator operator;
        operator = (a) -> {
            for (int x : a) {
                if (x % 3 == 0) {
                    System.out.printf("%d ", Math.abs(x));
                }
            }
        };
        operator.getRes(arr);

    }

    interface Operator {
        void getRes(int[] arr);
    }
}
