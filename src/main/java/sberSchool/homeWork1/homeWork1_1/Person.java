package sberSchool.homeWork1.homeWork1_1;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public boolean isMan() {
        return man;
    }

    public String getName() {
        return name;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    @Override
    public String toString() {
        return  name;
    }

    public void marry(Person newSpouse) {
        if ((spouse == null & newSpouse.getSpouse() == null) & (man != newSpouse.isMan())) {
            spouse = newSpouse;
            newSpouse.setSpouse(this);
            return;
        }
        if (man == newSpouse.isMan()) {
            System.out.println("marry is not possible");
            return;
        }
        if(this.spouse != null) {
            divorce(this.spouse);
            marry(newSpouse);
            return;
        } else {
            newSpouse.divorce(newSpouse.getSpouse());
            marry(newSpouse);
            return;
        }

    }

    public void divorce(Person spouse) {
        this.spouse = null;
        spouse.setSpouse(null);
    }

}
