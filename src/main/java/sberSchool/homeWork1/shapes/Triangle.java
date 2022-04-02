package sberSchool.homeWork1.shapes;

public class Triangle implements Shape {
    int a;
    int b;
    int c;

    public Triangle(int a, int b, int c) throws Exception {
        this.a = a;
        this.b = b;
        this.c = c;
        isTriangle();
    }

    public double area() {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double perimeter() {
        return a + b + c;
    }
    private void isTriangle() throws Exception {
        if(((a + b) <= c) || ((a + c) <= b) || ((c + b) <= a)) {
            throw new Exception("Такого треугольника не существует.");
        }
    }
}
