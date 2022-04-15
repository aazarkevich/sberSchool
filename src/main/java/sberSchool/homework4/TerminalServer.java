package sberSchool.homework4;

import java.util.List;
import java.util.Map;

public class TerminalServer {
    private Map<Bill, Integer> billsPassword = Map.of(
            new Bill(1, 1000), 1234,
            new Bill(2, 2000),  5678,
            new Bill(3, 3000), 2468,
            new Bill(4, 4444), 1357
    );

    public void addBill (Bill bill, Integer password) {
        billsPassword.put(bill, password);
    }

    public Bill getBillById(int id) {
        return null;
    }
}
