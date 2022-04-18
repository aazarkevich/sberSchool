package sberSchool.homework4.task1.exceptions;

public class InvalidBanknoteException extends Exception {
    public InvalidBanknoteException() {
        super("Недопустимая банкнота.");
    }
}
