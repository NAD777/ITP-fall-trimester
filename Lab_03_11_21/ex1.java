package com.company;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.security.AccessControlException;

class Main {


    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader("inputFile.txt");
            fw = new FileWriter("outputFile.txt");
            String str = "";
            int i;
            while ((i = fr.read()) != -1) {
                str += (char) i;
            }
            System.out.println(str);
            fw.write(str);
            System.out.println("File reading and writing both done.");

        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            e.printStackTrace();
        } catch (AccessControlException e) {
            System.out.println("AccessControlException");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Write file Exception");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception occured");
            e.printStackTrace();
        }
        finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    System.out.println("Exception while closing");
                    e.printStackTrace();
                }
            }
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    System.out.println("Exception while closing");
                    e.printStackTrace();
                }
            }
        }
    }
}
