package com.company;

import javax.crypto.Mac;
import java.util.Scanner;


enum Money {
    One(1), Two(2), Five(5), Ten(10), Fifty(50), Hundred(100);

    private final int denomination;

    Money(int den) {
        this.denomination = den;
    }

    public int getDenomination() {
        return this.denomination;
    }
}

enum Machine {
    COCA_COLA("Coca-Cola", 55),
    FANTA("Fanta", 50),
    SPRITE("Sprite", 50),
    PEPSI("Pepsi", 47),
    MIRINDA("Mirinda", 45),
    SEVEN_UP("7 UP", 45);

    private final String name;
    private final int price;

    Machine(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

class VendingMachine {
    private int insertedMoney = 0;

    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        vm.seeMenu();
    }

    private void seeMenu() {
        System.out.println("The menu is:");
        for (Machine machine : Machine.values()) {
            System.out.printf("%d. %s - %s₽\n", machine.ordinal() + 1, machine.getName(), machine.getPrice());
        }
    }

    private void addMoney(int amount) {
        this.insertedMoney += amount;
    }

    private void buyDrink(int drinkItem) {
        for (Machine machine : Machine.values()) {
            if ((machine.ordinal() + 1) == drinkItem) {
                this.insertedMoney -= machine.getPrice();
                System.out.printf("Please take your %s\n", machine.getName());
            }
        }
    }
}




