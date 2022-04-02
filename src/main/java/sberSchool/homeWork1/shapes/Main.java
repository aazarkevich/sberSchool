package sberSchool.homeWork1.shapes;

public class Main {
    public static void main(String[] args) throws Exception {
        Shape circle = new Circle(4);
        System.out.println(circle.area());
        System.out.println(circle.perimeter());

        Shape rect = new Rect(2,3);
        System.out.println(rect.area());
        System.out.println(rect.perimeter());

        Shape square = new Square(5);
        System.out.println(square.area());
        System.out.println(square.perimeter());

        Shape triangle = new Triangle(2,2,3);
        System.out.println(triangle.area());
        System.out.println(triangle.perimeter());
    }
}
