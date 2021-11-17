package com.company;


import java.util.*;

abstract class Media {
    private String author;
    private String title;

    Media(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getInfo() {
        return String.format("Title: %s, Title: %s", this.author, this.title);
    }
}

class Book extends Media {
    Book(String author, String title) {
        super(author, title);
    }
}

class Magazine extends Media {

    Magazine(String author, String title) {
        super(author, title);
    }
}

class Library<T extends Media> {
    private ArrayList<T> res = new ArrayList<>();

    public void addRes(T newItem) {
        this.res.add(newItem);
    }

    public String getWhole() {
        StringBuilder result = new StringBuilder();
        for (T x : this.res) {
            result.append(x.getInfo()).append("\n");
        }
        return result.toString();
    }
}

class Main {
    public static void main(String[] args) {
        Library lib = new Library<>();
        lib.addRes(new Book("Tolstoy", "War and peace"));
        lib.addRes(new Magazine("Pupa", "Anekdoti kategorii B"));
        System.out.print(lib.getWhole());
    }
}
