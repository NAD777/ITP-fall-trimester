
package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Box {
    int x;
    int y;
    int z;

    public Box(int x, int y, int z) {
        this.x = Math.min(x, Math.min(y, z));
        this.z = Math.max(x, Math.max(y, z));
        this.y = x + y + z - this.x - this.z;
    }

    public boolean fits(Box other) {
        return other.x < this.x && other.y < this.y && other.z < this.z;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        Scanner fileIn = new Scanner(new File("input.txt"));
        FileWriter fileWriter = new FileWriter("output.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        String inp = fileIn.nextLine();
        String arr[] = inp.split("] \\[");

        arr[0] = arr[0].substring(1, arr[0].length());
        arr[arr.length - 1] = arr[arr.length - 1].substring(0, arr[arr.length - 1].length() - 1);

        Box boxes[] = new Box[arr.length];

        for (int i = 0; i < arr.length; i++) {
            String[] tmp = arr[i].split(" ");
            boxes[i] = new Box(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]));

        }

        Arrays.sort(boxes, (o1, o2) -> {
            if (o1.fits(o2)) {
                return -1;
            }
            return 1;
        });

        int ans = 1;
        int cur = 1;
        for (int i = 0; i < boxes.length - 1; i++) {
            if (boxes[i].fits(boxes[i + 1])) {
                cur += 1;
                ans = Math.max(cur, ans);
            } else {
                cur = 1;
            }
        }
        printWriter.println(ans);
        printWriter.close();
    }
}


