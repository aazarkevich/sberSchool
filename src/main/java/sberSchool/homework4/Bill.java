package sberSchool.homework4;

import java.util.Objects;

public class Bill {
    private int id;
    private int countMoney;

    public Bill(int id, int countMoney) {
        this.id = id;
        this.countMoney = countMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountMoney() {
        return countMoney;
    }

    public void setCountMoney(int countMoney) {
        this.countMoney = countMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return id == bill.id &&
                countMoney == bill.countMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countMoney);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                '}';
    }
}
