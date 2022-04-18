package sberSchool.homework4.task1.exceptions;

public class BillNotFoundException extends Exception {
    public BillNotFoundException() {
        super("Bill not found.");
    }

    public BillNotFoundException(String message) {
        super(message);
    }
}
