
package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Author a1 = new Author("Anton", "anton.nehaeff@yandex.ru", "Male");
        Book b1 = new Book("ITP-fall-trimester", a1, 100.99, 1);
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
    private double price;
    private int qty;

    Book(String name, Author author, double price, int qty) {
        this.setName(name);
        this.setAuthor(author);
        this.setPrice(price);
        this.setQty(qty);
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    Author getAuthor() {
        return this.author;
    }

    void setAuthor(Author author) {
        this.author = author;
    }

    double getPrice() {
        return this.price;
    }

    void setPrice(double price) {
        this.price = price;
    }

    int getQty() {
        return this.qty;
    }

    void setQty(int qty) {
        this.qty = qty;
    }

    String getString() {
        return String.format("----------\nAuthor Info:\n%s\n\nBook title: %s\nPrice: %.2f\nQuanity: %d\n----------\n",
                this.author.getString(), this.getName(), this.getPrice(), this.getQty());
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
