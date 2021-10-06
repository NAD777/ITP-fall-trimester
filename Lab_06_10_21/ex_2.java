
package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Author a1 = new Author("Anton", "anton.nehaeff@yandex.ru", "Male");
        Book b1 = new Book("ITP-fall-trimester", a1, 100, 1);
        Library library = new Library();
        library.addBook(b1);
        Book b2 = new Book("Math Analysis", a1, 500, 1);
        library.addBook(b2);
        library.printBooks();
    }
}

class Author {
    private String name;
    private String eMail;
    private String gender;

    Author(String name, String eMail, String gender) {
        this.name = name;
        this.eMail = eMail;
        this.gender = gender;
    }

    String getString() {
        return String.format("Name: %s\nEmail: %s\nGender: %s", this.name, this.eMail, this.gender);
    }
}

class Book {
    private String name;
    private Author author;
    private int price;
    private int qty;

    Book(String name, Author author, int price, int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    String getString() {
        return String.format("----------\nAuthor Info:\n%s\n\nBook title: %s\nPrice: %d\nQuanity: %d\n----------\n",
                this.author.getString(), this.name, this.price, this.qty);
    }
}

class Library {
    private List<Book> books = new ArrayList<Book>();

    void addBook(Book book) {
        this.books.add(book);
    }

    void printBooks() {
        int number = 1;
        for (Book book : this.books) {
            System.out.format("\nBook #%d\n%s", number, book.getString());
            number += 1;
        }
    }
}
