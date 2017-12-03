package com.github.azdrachak.atm.controller;

import com.github.azdrachak.atm.model.MoneyContainer;
import com.github.azdrachak.atm.model.MoneyCount;

public class GetRemainingMoney {
    public int getRemainingMoney(MoneyContainer container) {
        return MoneyCount.getRemainingMoney(container);
    }
}
