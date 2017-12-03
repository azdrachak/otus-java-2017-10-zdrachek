package com.github.azdrachak.atm.model;

import com.github.azdrachak.atm.exceptions.InvalidMoneyAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MoneySorterTest {
    private HashMap<RubleNominal, Integer> moneyToAdd;
    private MoneyContainer container;

    @BeforeEach
    void setUp() {
        HashMap<RubleNominal, Integer> money = new HashMap<>();
        money.put(RubleNominal.R100, 2);
        money.put(RubleNominal.R500, 4);
        money.put(RubleNominal.R1000, 6);
        money.put(RubleNominal.R2000, 8);
        money.put(RubleNominal.R5000, 10);

        moneyToAdd = new HashMap<>();
        moneyToAdd.put(RubleNominal.R100, 10);
        moneyToAdd.put(RubleNominal.R500, 50);
        moneyToAdd.put(RubleNominal.R1000, 100);
        moneyToAdd.put(RubleNominal.R2000, 200);
        moneyToAdd.put(RubleNominal.R5000, 500);

        container = new MoneyContainer(money);
    }

    @Test
    void putMoney() {
        MoneySorter.putMoney(container, moneyToAdd);
        assertEquals(12, container.get(RubleNominal.R100));
        assertEquals(54, container.get(RubleNominal.R500));
        assertEquals(106, container.get(RubleNominal.R1000));
        assertEquals(208, container.get(RubleNominal.R2000));
        assertEquals(510, container.get(RubleNominal.R5000));
    }

    @Test
    void putMoneySum() {
        try {
            MoneySorter.putMoney(container, 28800); //5000*5 + 2000*1 + 1000*1 + 500*1 + 100*3
        } catch (InvalidMoneyAmount invalidMoneyAmount) {
            invalidMoneyAmount.printStackTrace();
        }
        assertEquals(5, container.get(RubleNominal.R100));
        assertEquals(5, container.get(RubleNominal.R500));
        assertEquals(7, container.get(RubleNominal.R1000));
        assertEquals(9, container.get(RubleNominal.R2000));
        assertEquals(15, container.get(RubleNominal.R5000));
    }

}