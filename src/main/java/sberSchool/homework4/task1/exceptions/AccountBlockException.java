package sberSchool.homework4.task1.exceptions;

public class AccountBlockException extends Exception {
    public AccountBlockException() {
        super("Введен 3 раза неправильно пароль, аккаунт заблокирован на 10 сек.");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public AccountBlockException(String message) {
        super(message);
    }
}
