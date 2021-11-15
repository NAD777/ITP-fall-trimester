package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    private static boolean checkFormat(String s) {
        Pattern pattern = Pattern.compile("^\\d\\d:\\d\\d$");
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }

    public static void main(String[] args) throws IOException {
        Scanner fileIn = new Scanner(new File("input.txt"));
        FileWriter fileWriter = new FileWriter("output.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        String inp = fileIn.nextLine();
        String a[] = inp.split(":");
        int hours = Integer.parseInt(a[0]);
        int minutes = Integer.parseInt(a[1]);
        if (!((0 <= hours && hours < 24) && (0 <= minutes && minutes < 60) && checkFormat(inp))) {
            printWriter.print("Wrong format");
            printWriter.close();
            System.exit(0);
        }

        if (hours >= 12) {
            hours -= 12;
        }

        int degHours = (hours * 30) % 360;

        // if test will be fixed
        //int degHours = (hours * 30 + minutes / 2) % 360;

        int degMinutes = minutes * 6 % 360;

        int absDeg = Math.abs(degHours - degMinutes);

        printWriter.print(Math.min(absDeg, 360 - absDeg));

        printWriter.close();
    }
}

/*
int degHours = (hours * 60 * 6) % 360;

        // if test will be fixed
        degHours = (hours * 60 * 6 + minutes / 2) % 360;
 */
