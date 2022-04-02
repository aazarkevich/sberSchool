package sberSchool.homeWork1.shapes;

public class Circle implements Shape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public double area() {
        return Math.PI * Math.pow(r, 2);
    }

    public double perimeter() {
        return 2 * r * Math.PI;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
}
