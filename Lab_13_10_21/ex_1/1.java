
package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    }
}

abstract class Animal {
    private int height;
    private int weight;
    private String color;

    public Animal(int height, int weight, String color) {
        this.height = height;
        this.weight = weight;
        this.color = color;
    }

    public abstract String eat();

    public abstract String sleep();

    public abstract String animalSound();
}


class Cat extends Animal {
    public Cat(int height, int weight, String color) {
        super(height, weight, color);
    }

    @Override
    public String eat() {
        return "Ням";
    }

    @Override
    public String sleep() {
        return "мрррр";
    }

    @Override
    public String animalSound() {
        return "Мур";
    }
}


class Cow extends Animal {
    public Cow(int height, int weight, String color) {
        super(height, weight, color);
    }

    @Override
    public String eat() {
        return "Жевк-жевк";
    }

    @Override
    public String sleep() {
        return "Мууууу";
    }

    @Override
    public String animalSound() {
        return "Му-му";
    }
}

class Dog extends Animal {
    public Dog(int height, int weight, String color) {
        super(height, weight, color);
    }

    @Override
    public String eat() {
        return "Mmm delicious food, thank you mister";
    }

    @Override
    public String sleep() {
        return "Рх-рх";
    }

    @Override
    public String animalSound() {
        return "Гав-гав";
    }
}
