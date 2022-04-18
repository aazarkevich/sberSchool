package sberSchool.homework4.task1;

import sberSchool.homework4.task1.exceptions.AccountBlockException;
import sberSchool.homework4.task1.exceptions.BillNotFoundException;
import sberSchool.homework4.task1.exceptions.PasswordNotFoundException;

public class PinValidator {
    private int countAttemps = 0;
    private TerminalServer terminalServer = new TerminalServer();

    public boolean validPassword(Bill bill, String password) throws AccountBlockException {
        System.out.println(password);
        try {
            if (password.equals(terminalServer.getPasswordBill(bill))) {
                return true;
            } else {
                throw new PasswordNotFoundException();
            }
        } catch (BillNotFoundException billNotFoundException) {
            billNotFoundException.printStackTrace();
        } catch (PasswordNotFoundException e) {
            e.printStackTrace();
            countAttemps++;
        }

        if (countAttemps == 3) {
            throw new AccountBlockException();
        }
        return false;
    }
}
