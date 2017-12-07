package com.github.azdrachak.atm.view;

import com.github.azdrachak.atm.model.RubleNominal;

import java.util.HashMap;

public class ShowResultsView {

    public void showRemainingSum(int amount) {
        System.out.printf("There are %d rubles left\n", amount);
    }

    public void showDispensedMoney(HashMap<RubleNominal, Integer> money) {
        System.out.println("Money dispensed:");
        for (RubleNominal rubleNominal : money.keySet()) {
            System.out.printf("%d banknotes: %d\n", rubleNominal.getValue(), money.get(rubleNominal));
        }
    }
}
