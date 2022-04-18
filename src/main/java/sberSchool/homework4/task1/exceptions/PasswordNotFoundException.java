package sberSchool.homework4.task1.exceptions;

public class PasswordNotFoundException extends Exception{
    public PasswordNotFoundException() {
        super("Неправильный пароль.");
    }
    public PasswordNotFoundException(String message) {
        super(message);
    }
}
