package sberSchool.homework4.task1.exceptions;

public class LackOfMoney extends Exception {
    public LackOfMoney() {
        super("На вашем счёте недостаточно средств.");
    }
}
