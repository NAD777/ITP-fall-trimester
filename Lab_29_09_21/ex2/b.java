package com.company;

import java.sql.Time;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Time start = new Time(10001000L);
        Time end = new Time(1000000000L);
        Time dur = new Time(end.getTime() - start.getTime());

        System.out.format("Start: %s\nEnd: %s\nDifference %s", start, end, dur);
        scanner.close();
    }
}
