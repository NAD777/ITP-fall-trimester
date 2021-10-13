
package com.company;


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TransferQueue;


interface Swimmable {
    void swim();

    void stopSwimming();
}

interface Flyable {
    void fly();

    void stopFlying();
}

interface Living {
    default void live() {
        System.out.printf("%s lives\n", this.getClass().getSimpleName());
    }
}


class Submarine implements Swimmable {

    boolean isSwimming = false;

    @Override
    public void swim() {
        if (!isSwimming) {
            System.out.printf("The %s is swimming in RF seas\n", this.getClass().getSimpleName());
            isSwimming = true;
        }
    }

    @Override
    public void stopSwimming() {
        if (!isSwimming) {
            System.out.printf("The %s has swam to the base\n", this.getClass().getSimpleName());
            isSwimming = false;
        }
    }
}

class Duck implements Swimmable, Flyable, Living {
    boolean isSwimming = false;
    boolean isFlying = false;

    @Override
    public void swim() {
        if (!isSwimming) {
            System.out.printf("The %s is swimming in lake\n", this.getClass().getSimpleName());
            isSwimming = true;
        }
    }

    @Override
    public void stopSwimming() {
        if (!isSwimming) {
            System.out.printf("The %s is going to it duckies\n", this.getClass().getSimpleName());
            isSwimming = false;
        }
    }

    @Override
    public void fly() {
        if (!isFlying) {
            System.out.printf("The %s is flying in the air\n", this.getClass().getSimpleName());
        }
    }

    @Override
    public void stopFlying() {
        if (isFlying) {
            System.out.println("The " + this.getClass().getSimpleName() +
                    " stopped flying in the air");
        }
    }
}

class Penguin implements Swimmable, Living {
    boolean isSwimming = false;

    public void swim() {
        if (!isSwimming) {
            System.out.printf("The %s is swimming in cold ocean\n", this.getClass().getSimpleName());
            isSwimming = true;
        }
    }

    @Override
    public void stopSwimming() {
        if (!isSwimming) {
            System.out.printf("The %s is going to it penguins\n", this.getClass().getSimpleName());
            isSwimming = false;
        }
    }
}


class InterfaceDemonstration {
    public static void main(String[] args) {
        Living[] livings = new Living[2];
        livings[0] = new Duck();
        livings[1] = new Penguin();
        letObjectsLive(livings);
    }

    private static void letObjectsLive(Living[] livings) {
        for (Living living : livings) {
            living.live();
        }
    }

}
