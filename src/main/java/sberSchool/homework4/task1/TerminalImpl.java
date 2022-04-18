package sberSchool.homework4.task1;

import sberSchool.homework4.task1.exceptions.AccountBlockException;
import sberSchool.homework4.task1.exceptions.IncorrectCharacterException;
import sberSchool.homework4.task1.exceptions.InvalidBanknoteException;
import sberSchool.homework4.task1.exceptions.LackOfMoney;

import java.util.Scanner;

public class TerminalImpl implements Terminal {
    private PinValidator pinValidator = new PinValidator();
    private boolean access = false;
    private Bill bill;
    private TerminalServer terminalServer = new TerminalServer();

    public TerminalImpl(Bill bill) {
        this.bill = bill;

    }

    @Override
    public void powerTerminal() {
        while (true) {
            if(enterPassword()) {
                viewsOperation();
            }
        }
    }

    private boolean enterPassword() {
        Scanner scanner = new Scanner(System.in);
        String password = "";
        System.out.println("Введите пароль: ");
        while (password.length() < 4) {
            char symbol = scanner.next().charAt(0);
            if (Character.isDigit(symbol)) {
                password += symbol;
            } else {
                try {
                    throw new IncorrectCharacterException();
                } catch (IncorrectCharacterException incorrectCharacterException) {
                    incorrectCharacterException.printStackTrace();
                    continue;
                }
            }
        }

        try {
            if (pinValidator.validPassword(bill, password)) {
                return true;
            }
        } catch (AccountBlockException accountBlockException) {
            accountBlockException.printStackTrace();
        }
        return false;
    }

    private void viewsOperation() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Банкнота должна быть кратна 100.");
                    int money = scanner.nextInt();
                    if (validBanknote(money)) {
                        try {
                            terminalServer.getMoney(bill, money);
                        } catch (LackOfMoney lackOfMoney) {
                            lackOfMoney.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Банкнота должна быть кратна 100.");
                    money = scanner.nextInt();
                    if(validBanknote(money)) {
                        terminalServer.setMoney(bill, money);
                    }
                    break;
                case 3:
                    System.out.println(terminalServer.balans(bill));
                    break;
                case 0: return ;
                default:
                    System.out.println("Такой операции нет.");
                    break;
            }
        }
    }

    private boolean validBanknote(int banknote) {
        if (banknote % 100 == 0) {
            return true;
        }
        try {
            throw new InvalidBanknoteException();
        } catch (InvalidBanknoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void menu() {
        System.out.println("Введите номер операции: ");
        System.out.println("1 - Снять деньги ");
        System.out.println("2 - Положить деньги ");
        System.out.println("3 - Баланс ");
        System.out.println("0 - Выход ");
    }
}
