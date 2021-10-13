
package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle(2, 3);
        System.out.printf("Area: %d\nPerimeter: %d\n\n", rec1.getArea(), rec1.getPerimeter());

        Circle cir1 = new Circle(2);
        System.out.printf("Area: %d\nPerimeter: %d\n\n", cir1.getArea(), cir1.getPerimeter());

        Square sq1 = new Square(3);
        System.out.printf("Area: %d\nPerimeter: %d\n\n", sq1.getArea(), sq1.getPerimeter());
    }
}

abstract class Figure {
    private int measure1 = 0;
    private int measure2 = 0;

    public Figure(int m1, int m2) {
        this.measure1 = m1;
        this.measure2 = m2;
    }

    public abstract int getArea();

    public abstract int getPerimeter();

    public int getMeasure1() {
        return measure1;
    }

    public int getMeasure2() {
        return measure2;
    }
}


class Rectangle extends Figure {

    public Rectangle(int m1, int m2) {
        super(m1, m2);
    }


    @Override
    public int getArea() {
        return this.getMeasure1() * this.getMeasure2();
    }

    @Override
    public int getPerimeter() {
        return 2 * (this.getMeasure1() + this.getMeasure2());
    }
}

class Circle extends Figure {

    public Circle(int m1, int m2) {
        super(m1, m2);
    }

    public Circle(int m1) {
        super(m1, 0);
    }

    @Override
    public int getArea() {
        return 3 * this.getMeasure1() * this.getMeasure1();
    }

    @Override
    public int getPerimeter() {
        return 2 * 3 * this.getMeasure1();
    }
}

class Triangle extends Figure {
    public Triangle(int m1, int m2) {
        super(m1, m2);
    }


    @Override
    public int getArea() {
        return this.getMeasure1() * this.getMeasure2() / 2;
    }

    @Override
    public int getPerimeter() {
        return (int) (2 * Math.sqrt(getMeasure1() * getMeasure1() + getMeasure2() * getMeasure2()) + 2 * getMeasure1());
    }
}


class Square extends Rectangle {
    public Square(int m1) {
        super(m1, m1);
    }
}

class Ellipse extends Figure {
    public Ellipse(int m1, int m2) {
        super(m1, m2);
    }

    @Override
    public int getArea() {
        return (int) (3.14 * this.getMeasure1() * this.getMeasure2());
    }

    @Override
    public int getPerimeter() {
        double a = this.getMeasure1();
        double b = this.getMeasure2();
        return (int) (2 * 3.14 * Math.sqrt((a * a + b * b) / 2));
    }
}
