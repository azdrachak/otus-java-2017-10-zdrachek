package com.github.azdrachak.atm;

import com.github.azdrachak.atm.controller.AddMoneyController;
import com.github.azdrachak.atm.controller.GetRemainingMoney;
import com.github.azdrachak.atm.controller.GiveMoneyController;
import com.github.azdrachak.atm.exceptions.InvalidMoneyAmount;
import com.github.azdrachak.atm.exceptions.NotEnoughMoney;
import com.github.azdrachak.atm.model.MoneyContainer;
import com.github.azdrachak.atm.model.RubleNominal;
import com.github.azdrachak.atm.view.ShowResultsView;

import java.util.HashMap;

public class ATM {

    private MoneyContainer container;

    private GetRemainingMoney getRemainingMoney = new GetRemainingMoney();
    private GiveMoneyController giveMoneyController = new GiveMoneyController();
    private AddMoneyController addMoneyController = new AddMoneyController();
    private ShowResultsView showResultsView = new ShowResultsView();

    ATM(MoneyContainer container) {
        this.container = container;
    }

    @SuppressWarnings("WeakerAccess")
    public int getRemainingMoney() {
        return getRemainingMoney.getRemainingMoney(container);
    }

    public void addMoney(MoneyContainer container, HashMap<RubleNominal, Integer> money) {
        addMoneyController.addMoney(container, money);
    }

    public void addMoney(MoneyContainer container, int amount) {
        addMoneyController.addMoney(container, amount);
    }

    public HashMap<RubleNominal, Integer> dispenseMoney(MoneyContainer container, int sum) {
        try {
            return giveMoneyController.dispenseMoney(container, sum);
        } catch (NotEnoughMoney | InvalidMoneyAmount e) {
            e.printStackTrace();
        }
        return null;
    }

    public void showRemainingSum() {
        showResultsView.showRemainingSum(getRemainingMoney());
    }

    public void showDispensedMoney(HashMap<RubleNominal, Integer> money) {
        showResultsView.showDispensedMoney(money);
    }
}
