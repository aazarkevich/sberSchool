package sberSchool.homeWork1.shapes;

public class Square implements Shape {
    private int a;

    public Square(int a) {
        this.a = a;
    }

    public double area() {
        return a * a;
    }

    public double perimeter() {
        return 4 * a;
    }
}
