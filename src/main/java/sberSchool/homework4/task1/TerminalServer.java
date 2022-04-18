package sberSchool.homework4.task1;

import sberSchool.homework4.task1.exceptions.BillNotFoundException;
import sberSchool.homework4.task1.exceptions.LackOfMoney;

import java.util.Map;

public class TerminalServer {
    private Map<Bill, String> billsPassword = Map.of(
            new Bill(1, 1000), "1234"
    );


    public void addBill (Bill bill, String password) {
        billsPassword.put(bill, password);
    }

    public String getPasswordBill(Bill bill) throws BillNotFoundException {
        if(billsPassword.containsKey(bill)) {
            return billsPassword.get(bill);
        } else {
            throw new BillNotFoundException();
        }
    }

    public int getMoney(Bill bill, int money) throws LackOfMoney {
        if (bill.getCountMoney() < money) {
            throw new LackOfMoney();
        }
        bill.setCountMoney(bill.getCountMoney() - money);
        return money;
    }

    public void setMoney(Bill bill, int money) {
        bill.setCountMoney(money);
    }

    public int balans(Bill bill) {
        return bill.getCountMoney();
    }

}
