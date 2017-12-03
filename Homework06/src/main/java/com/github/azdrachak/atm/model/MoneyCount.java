package com.github.azdrachak.atm.model;

import com.github.azdrachak.atm.controller.GetRemainingMoney;
import com.github.azdrachak.atm.exceptions.InvalidMoneyAmount;
import com.github.azdrachak.atm.exceptions.NotEnoughMoney;

import java.util.*;

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
        GetRemainingMoney grm = new GetRemainingMoney();

        if (sumToDispense > grm.getRemainingMoney(container)) throw new NotEnoughMoney();
        if (sumToDispense < 0 || sumToDispense % 100 != 0) throw new InvalidMoneyAmount();

        List<RubleNominal> nominals = new ArrayList<>(container.getMoney().keySet());
        nominals.sort(Collections.reverseOrder());

        for (RubleNominal nominal : nominals) {
            if (remainingSum >= nominal.getValue()) {
                dispenseMoney.put(nominal, remainingSum / nominal.getValue());
                container.add(nominal, -1 * dispenseMoney.get(nominal));
            }
            remainingSum %= nominal.getValue();
        }

        return dispenseMoney;
    }
}
