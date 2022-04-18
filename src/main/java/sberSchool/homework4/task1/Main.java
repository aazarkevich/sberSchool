package sberSchool.homework4.task1;

public class Main {
    public static void main(String[] args) {
        Bill bill = new Bill(1,1000);
        TerminalImpl terminal = new TerminalImpl(bill);
        terminal.powerTerminal();
//        System.out.println(1001 % 100);
    }
}
