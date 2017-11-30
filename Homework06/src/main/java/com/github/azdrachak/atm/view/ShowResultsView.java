package com.github.azdrachak.atm.view;

import com.github.azdrachak.atm.controller.GetRemainingMoney;
import com.github.azdrachak.atm.model.MoneyContainer;
import com.github.azdrachak.atm.model.RubleNominal;

import java.util.HashMap;

public class ShowResultsView {
    private MoneyContainer container;

    public ShowResultsView(MoneyContainer container) {
        this.container = container;
    }

    public void showRemainingSum() {
        System.out.printf("There are %d rubles left\n", GetRemainingMoney.getRemainingMoney(container));
    }

    public void showDispensedMoney(HashMap<RubleNominal, Integer> money) {
        System.out.println("Money dispensed:");
        for (RubleNominal rubleNominal : money.keySet()) {
            System.out.printf("%d banknotes: %d\n", rubleNominal.getValue(), money.get(rubleNominal));
        }
    }
}
