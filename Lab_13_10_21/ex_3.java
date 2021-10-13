
package com.company;


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TransferQueue;

public class Main {

    public static void main(String[] args) {
        AbstractClassDemonstration a = new AbstractClassDemonstration();
        a.printObjs();
    }
}


abstract class Creature {
    String name = null;
    boolean isAlive = false;

    abstract public void bear(String name);

    abstract public void die();

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
    public void bear(String name) {
        this.name = name;
        this.isAlive = true;
        System.out.printf("%s called %s has born\n", this.getClass().getSimpleName(), this.getName());
    }

    @Override
    public void die() {
        System.out.printf("%s called %s has died\n", this.getClass().getSimpleName(), this.getName());
    }
}


class Dog extends Creature {
    @Override
    public void bear(String name) {
        this.name = name;
        this.isAlive = true;
        System.out.printf("%s called %s has born\n", this.getClass().getSimpleName(), this.getName());
    }

    @Override
    public void die() {
        System.out.printf("%s called %s has died\n", this.getClass().getSimpleName(), this.getName());
    }

    void bark() {
        System.out.print("Bark - bark!!\n");
    }
}


class Alien extends Creature {
    @Override
    public void bear(String name) {
        this.name = name;
        this.isAlive = true;
        System.out.printf("%s called %s has born\n", this.getClass().getSimpleName(), this.getName());
    }

    @Override
    public void die() {
        System.out.printf("%s called %s has died\n", this.getClass().getSimpleName(), this.getName());
    }
}

class AbstractClassDemonstration {
    ArrayList<Object> arr = new ArrayList<>();

    public AbstractClassDemonstration() {
        this.arr.add(new Human());
        this.arr.add(new Dog());
        this.arr.add(new Alien());
    }

    public void printObjs() {
        for (int i = 0; i < this.arr.size(); i++) {
            this.arr.get(i).bear();
        }
    }
}
