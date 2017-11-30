package com.github.azdrachak.atm;

import com.github.azdrachak.atm.controller.AddMoneyController;
import com.github.azdrachak.atm.controller.GiveMoneyController;
import com.github.azdrachak.atm.exceptions.InvalidMoneyAmount;
import com.github.azdrachak.atm.exceptions.NotEnoughMoney;
import com.github.azdrachak.atm.model.MoneyContainer;
import com.github.azdrachak.atm.model.RubleNominal;
import com.github.azdrachak.atm.view.ShowResultsView;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        MoneyContainer container = new MoneyContainer();
        ShowResultsView view = new ShowResultsView(container);
        view.showRemainingSum();

        HashMap<RubleNominal, Integer> money = new HashMap<>();
        money.put(RubleNominal.R100, 5);

        System.out.println("Add 5 100 rubles banknotes");
        AddMoneyController.addMoney(container, money);
        view.showRemainingSum();

        System.out.println("Add 25700 rubles");
        AddMoneyController.addMoney(container, 25700);
        view.showRemainingSum();

        System.out.println("Dispense 6800 rubles");
        HashMap<RubleNominal, Integer> dispensedMoney = new HashMap<>();
        try {
            dispensedMoney = GiveMoneyController.dispenseMoney(container, 6800);
        } catch (NotEnoughMoney | InvalidMoneyAmount notEnoughMoney) {
            notEnoughMoney.printStackTrace();
        }
        view.showDispensedMoney(dispensedMoney);
        view.showRemainingSum();
    }
}
