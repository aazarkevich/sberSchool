package sberSchool.homework4.task1.exceptions;

public class IncorrectCharacterException extends Exception {
    public IncorrectCharacterException() {
        super("Введен символ отличен от цифры");
    }
}
