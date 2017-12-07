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

    public ATM(MoneyContainer container) {
        this.container = container;
    }

    @SuppressWarnings("WeakerAccess")
    public int getRemainingMoney() {
        return getRemainingMoney.getRemainingMoney(container);
    }

    public ATM addMoney(HashMap<RubleNominal, Integer> money) {
        addMoneyController.addMoney(container, money);
        return this;
    }

    public ATM addMoney(int amount) {
        addMoneyController.addMoney(container, amount);
        return this;
    }

    public HashMap<RubleNominal, Integer> dispenseMoney(int sum) {
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
