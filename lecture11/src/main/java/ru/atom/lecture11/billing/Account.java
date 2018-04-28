package ru.atom.lecture11.billing;

/**
 * Created by Ivan Makarychev on 23.04.18.
 */
public class Account {
    int money;
    final String name;

    public Account(String user, int money) {
        this.name = user;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public int compareTo(Account other) {
        return name.compareTo(other.name);
    }
}
