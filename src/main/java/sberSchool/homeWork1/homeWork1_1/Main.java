package sberSchool.homeWork1.homeWork1_1;

public class Main {
    public static void main(String[] args) {
        Person william = new Person(true, "William");
        Person michael = new Person(true, "Michael");

        Person emma = new Person(false, "Emma");
        Person charlotte = new Person(false, "Charlotte");

        william.marry(emma);
        System.out.println(william.getSpouse());
        System.out.println(emma.getSpouse());

        michael.marry(charlotte);
        System.out.println(michael.getSpouse());
        System.out.println(charlotte.getSpouse());

        william.marry(charlotte);
        System.out.println(william.getSpouse());
        System.out.println(charlotte.getSpouse());
        System.out.println(emma.getSpouse());
        System.out.println(michael.getSpouse());

//        william.marry(michael);
//        System.out.println(william.getSpouse());
//        System.out.println(charlotte.getSpouse());
//        System.out.println(emma.getSpouse());
//        System.out.println(michael.getSpouse());
    }
}
