package com.github.azdrachak.atm.controller;

import com.github.azdrachak.atm.exceptions.InvalidMoneyAmount;
import com.github.azdrachak.atm.exceptions.NotEnoughMoney;
import com.github.azdrachak.atm.model.MoneyContainer;
import com.github.azdrachak.atm.model.MoneyCount;
import com.github.azdrachak.atm.model.RubleNominal;

import java.util.HashMap;

public class GiveMoneyController {
    public static HashMap<RubleNominal, Integer> dispenseMoney(MoneyContainer container, int sum) throws
            NotEnoughMoney, InvalidMoneyAmount {
        return MoneyCount.getCashToDispense(container, sum);
    }
}
