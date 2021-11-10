package com.company;


import java.util.ArrayList;


class Animal {
    private String name;
    private int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public String getInfo() {
        return String.format("---------\nAnimal: %s\nAge: %d\n---------", this.name, this.age);
    }
}


class Main {
    private static ArrayList<Animal> ListAnim = new ArrayList<Animal>();

    public static void addAnimal(String name, int age) {
        ListAnim.add(new Animal(name, age));
    }

    public static void removeAnimal(int index) {
        ListAnim.remove(index);
    }

    public static void updateAnimal(int index, String name, int age) {
        ListAnim.set(index, new Animal(name, age));
    }

    public static void displayAnimals() {
        for (Animal x : ListAnim) {
            System.out.println(x.getInfo());
        }
    }

    public static void main(String[] args) {
        addAnimal("Anton", 18);
        addAnimal("Bipka", 3);
        displayAnimals();
        System.out.println("");
        updateAnimal(1, "Brukva", 5);
        displayAnimals();
        System.out.println("");
        removeAnimal(0);
        displayAnimals();
    }
}
