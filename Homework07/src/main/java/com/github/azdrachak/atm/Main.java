package com.github.azdrachak.atm;

import com.github.azdrachak.atm.model.MoneyContainer;
import com.github.azdrachak.atm.model.RubleNominal;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        MoneyContainer container = new MoneyContainer();
        ATM atm = new ATM("ATM", container);

        atm.showRemainingSum();

        HashMap<RubleNominal, Integer> money = new HashMap<>();
        money.put(RubleNominal.R100, 5);

        System.out.println("Add 5 100 rubles banknotes");
        atm.addMoney(money);
        atm.showRemainingSum();

        System.out.println("Add 25700 rubles");
        atm.addMoney(25700);
        atm.showRemainingSum();

        System.out.println("Dispense 6800 rubles");
        HashMap<RubleNominal, Integer> dispensedMoney = atm.dispenseMoney(6800);
        atm.showDispensedMoney(dispensedMoney);
        atm.showRemainingSum();
    }
}
