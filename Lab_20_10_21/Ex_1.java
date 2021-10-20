
package com.company;


import java.util.Dictionary;

abstract class User {
    private int id;
    private int name;

    abstract public void Choice();
}

class Patient extends User {
    int money = 0;
    int id;
    String name;
    private Bill bill;

    @Override
    public void Choice() {

    }

    public void payBill() {

    }
}

class Bill {
    int amountMoney;
    private Receptionist receptionist;
}

class Receptionist extends User {

    @Override
    public void Choice() {

    }

    public void giveAppoint() {

    }

    public void generateBill() {

    }
}

class Doctor extends User {

    @Override
    public void Choice() {

    }

    public void CheckPatient() {

    }
}

