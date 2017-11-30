package com.github.azdrachak.atm.model;

import java.util.HashMap;

public class MoneyContainer {
    private HashMap<RubleNominal, Integer> money = new HashMap<>();

    public MoneyContainer() {
        money.put(RubleNominal.R100, 0);
        money.put(RubleNominal.R500, 0);
        money.put(RubleNominal.R1000, 0);
        money.put(RubleNominal.R2000, 0);
        money.put(RubleNominal.R5000, 0);
    }

    public MoneyContainer(HashMap<RubleNominal, Integer> money) {
        this.money = money;
    }

    HashMap<RubleNominal, Integer> getMoney() {
        return money;
    }

    int get100() {
        return money.get(RubleNominal.R100);
    }

    int get500() {
        return money.get(RubleNominal.R500);
    }

    int get1000() {
        return money.get(RubleNominal.R1000);
    }

    int get2000() {
        return money.get(RubleNominal.R2000);
    }

    int get5000() {
        return money.get(RubleNominal.R5000);
    }

    void add100(int amount) {
        money.put(RubleNominal.R100, get100() + amount);
    }

    void add500(int amount) {
        money.put(RubleNominal.R500, get500() + amount);
    }

    void add1000(int amount) {
        money.put(RubleNominal.R1000, get1000() + amount);
    }

    void add2000(int amount) {
        money.put(RubleNominal.R2000, get2000() + amount);
    }

    void add5000(int amount) {
        money.put(RubleNominal.R5000, get5000() + amount);
    }
}
