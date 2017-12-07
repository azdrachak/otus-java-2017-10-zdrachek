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

    public HashMap<RubleNominal, Integer> getMoney() {
        return money;
    }

    int get(RubleNominal nominal) {
        return money.get(nominal);
    }

    void put(RubleNominal nominal, int amount) {
        money.put(nominal, amount);
    }

    void add(RubleNominal nominal, int amount) {
        money.put(nominal, get(nominal) + amount);
    }
}
