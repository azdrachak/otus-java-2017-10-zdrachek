package com.github.azdrachak.atm.model;

import com.github.azdrachak.atm.controller.GetRemainingMoney;
import com.github.azdrachak.atm.exceptions.InvalidMoneyAmount;
import com.github.azdrachak.atm.exceptions.NotEnoughMoney;

import java.util.HashMap;

public class MoneyCount {
    public static int getRemainingMoney(MoneyContainer container) {
        HashMap<RubleNominal, Integer> money = container.getMoney();
        int sum = 0;
        for (RubleNominal rubleNominal : money.keySet()) {
            sum += money.get(rubleNominal) * rubleNominal.getValue();
        }
        return sum;
    }

    public static HashMap<RubleNominal, Integer> getCashToDispense(MoneyContainer container, int sumToDispense)
            throws InvalidMoneyAmount, NotEnoughMoney {
        HashMap<RubleNominal, Integer> dispenseMoney = new HashMap<>();
        int remainingSum = sumToDispense;

        if (sumToDispense > GetRemainingMoney.getRemainingMoney(container)) throw new NotEnoughMoney();
        if (sumToDispense < 0 || sumToDispense % 100 != 0) throw new InvalidMoneyAmount();

        if (remainingSum >= 5000) {
            dispenseMoney.put(RubleNominal.R5000, remainingSum / 5000);
            container.add5000(-1 * dispenseMoney.get(RubleNominal.R5000));
        }
        remainingSum %= 5000;
        if (remainingSum >= 2000) {
            dispenseMoney.put(RubleNominal.R2000, remainingSum / 2000);
            container.add2000(-1 * dispenseMoney.get(RubleNominal.R2000));
        }
        remainingSum %= 2000;
        if (remainingSum >= 1000) {
            dispenseMoney.put(RubleNominal.R1000, remainingSum / 1000);
            container.add1000(-1 * dispenseMoney.get(RubleNominal.R1000));
        }
        remainingSum %= 1000;
        if (remainingSum >= 500) {
            dispenseMoney.put(RubleNominal.R500, remainingSum / 500);
            container.add500(-1 * dispenseMoney.get(RubleNominal.R500));
        }
        remainingSum %= 500;
        if (remainingSum >= 100) {
            dispenseMoney.put(RubleNominal.R100, remainingSum / 100);
            container.add100(-1 * dispenseMoney.get(RubleNominal.R100));
        }

        return dispenseMoney;
    }
}
