package com.github.azdrachak.atm.model;

import com.github.azdrachak.atm.controller.GetRemainingMoney;
import com.github.azdrachak.atm.exceptions.InvalidMoneyAmount;
import com.github.azdrachak.atm.exceptions.NotEnoughMoney;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MoneyCountTest {
    private MoneyContainer container;

    @BeforeEach
    void setUp() {
        HashMap<RubleNominal, Integer> money = new HashMap<>();
        money.put(RubleNominal.R100, 10);
        money.put(RubleNominal.R500, 20);
        money.put(RubleNominal.R1000, 30);
        money.put(RubleNominal.R2000, 40);
        money.put(RubleNominal.R5000, 50);
        container = new MoneyContainer(money);
    }

    @Test
    void getMoney() {
        assertEquals(10 * 100 + 20 * 500 + 30 * 1000 + 40 * 2000 + 50 * 5000, GetRemainingMoney.getRemainingMoney(container));
    }

    @Test
    void getCashToDispense() throws NotEnoughMoney, InvalidMoneyAmount {
        int initialSum = GetRemainingMoney.getRemainingMoney(container);
        int sumToDispense = 11700;
        HashMap<RubleNominal, Integer> money = new HashMap<>();
        money.put(RubleNominal.R5000, 2);
        money.put(RubleNominal.R1000, 1);
        money.put(RubleNominal.R500, 1);
        money.put(RubleNominal.R100, 2);
        assertEquals(money, MoneyCount.getCashToDispense(container, sumToDispense));
        assertEquals(initialSum - sumToDispense, GetRemainingMoney.getRemainingMoney(container));
    }

}