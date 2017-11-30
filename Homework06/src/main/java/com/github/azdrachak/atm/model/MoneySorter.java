package com.github.azdrachak.atm.model;

import com.github.azdrachak.atm.exceptions.InvalidMoneyAmount;

import java.util.HashMap;

public class MoneySorter {
    public static void putMoney(MoneyContainer container, HashMap<RubleNominal, Integer> money) {
        for (RubleNominal rubleNominal : money.keySet()) {
            switch (rubleNominal) {
                case R100:
                    container.add100(money.get(rubleNominal));
                    break;
                case R500:
                    container.add500(money.get(rubleNominal));
                    break;
                case R1000:
                    container.add1000(money.get(rubleNominal));
                    break;
                case R2000:
                    container.add2000(money.get(rubleNominal));
                    break;
                case R5000:
                    container.add5000(money.get(rubleNominal));
                    break;
            }
        }
    }

    public static void putMoney(MoneyContainer container, int money) throws InvalidMoneyAmount {
        if (money % 100 != 0 || money < 0) throw new InvalidMoneyAmount();

        int remainingMoney = money;
        container.add5000(remainingMoney / 5000);
        remainingMoney %= 5000;
        container.add2000(remainingMoney / 2000);
        remainingMoney %= 2000;
        container.add1000(remainingMoney / 1000);
        remainingMoney %= 1000;
        container.add500(remainingMoney / 500);
        remainingMoney %= 500;
        container.add100(remainingMoney / 100);
    }
}
