
package com.company;


import java.util.concurrent.TransferQueue;

public class Main {

    public static void main(String[] args) {
        Human h1 = new Human();
        h1.bear("Anton");
    }
}


abstract class Creature {
    String name = null;
    boolean isAlive = false;

    abstract void bear(String name);

    abstract void die();

    void setName(String s) {
        this.name = s;
    }

    String getName() {
        return this.name;
    }

    void shoutName() {
        System.out.printf("%s\n", (this.name == null ? "Error" : this.name));
    }
}


class Human extends Creature {
    @Override
    void bear(String name) {
        this.name = name;
        this.isAlive = true;
        System.out.printf("%s called %s has born\n", this.getClass().getSimpleName(), this.getName());
    }

    @Override
    void die() {
        System.out.printf("%s called %s has died\n", this.getClass().getSimpleName(), this.getName());
    }
}


class Dog extends Creature {
    @Override
    void bear(String name) {
        this.name = name;
        this.isAlive = true;
        System.out.printf("%s called %s has born\n", this.getClass().getSimpleName(), this.getName());
    }

    @Override
    void die() {
        System.out.printf("%s called %s has died\n", this.getClass().getSimpleName(), this.getName());
    }

    void bark() {
        System.out.print("Bark - bark!!\n");
    }
}


class Alien extends Creature {
    @Override
    void bear(String name) {
        this.name = name;
        this.isAlive = true;
        System.out.printf("%s called %s has born\n", this.getClass().getSimpleName(), this.getName());
    }

    @Override
    void die() {
        System.out.printf("%s called %s has died\n", this.getClass().getSimpleName(), this.getName());
    }
}
