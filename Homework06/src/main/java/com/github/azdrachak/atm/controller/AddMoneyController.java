package com.github.azdrachak.atm.controller;

import com.github.azdrachak.atm.exceptions.InvalidMoneyAmount;
import com.github.azdrachak.atm.model.MoneyContainer;
import com.github.azdrachak.atm.model.MoneySorter;
import com.github.azdrachak.atm.model.RubleNominal;

import java.util.HashMap;

public class AddMoneyController {
    public static void addMoney(MoneyContainer container, HashMap<RubleNominal, Integer> money) {
        MoneySorter.putMoney(container, money);
    }

    public static void addMoney(MoneyContainer container, int amount) {
        try {
            MoneySorter.putMoney(container, amount);
        } catch (InvalidMoneyAmount invalidMoneyAmount) {
            invalidMoneyAmount.printStackTrace();
        }
    }
}
