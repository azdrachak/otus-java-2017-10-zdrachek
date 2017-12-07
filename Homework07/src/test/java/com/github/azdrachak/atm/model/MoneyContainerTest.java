package com.github.azdrachak.atm.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MoneyContainerTest {
    private HashMap<RubleNominal, Integer> money;
    private MoneyContainer emptyContainer;
    private MoneyContainer container;

    @BeforeEach
    void setUp() {
        money = new HashMap<>();
        money.put(RubleNominal.R100, 2);
        money.put(RubleNominal.R500, 4);
        money.put(RubleNominal.R1000, 6);
        money.put(RubleNominal.R2000, 8);
        money.put(RubleNominal.R5000, 10);

        emptyContainer = new MoneyContainer();
        container = new MoneyContainer(money);
    }

    @Test
    void get100() {
        assertEquals(2, container.get(RubleNominal.R100));
    }

    @Test
    void get100_empty() {
        assertEquals(0, emptyContainer.get(RubleNominal.R100));
    }

    @Test
    void getMoney() {
        assertTrue(money.equals(container.getMoney()));
    }

    @Test
    void put() {
        container.add(RubleNominal.R100, 10);
        assertEquals(12, container.get(RubleNominal.R100));
    }
}