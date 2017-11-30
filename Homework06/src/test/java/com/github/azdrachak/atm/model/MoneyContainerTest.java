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
        assertEquals(2, container.get100());
    }

    @Test
    void get100_empty() {
        assertEquals(0, emptyContainer.get100());
    }

    @Test
    void get500() {
        assertEquals(4, container.get500());
    }

    @Test
    void get500_empty() {
        assertEquals(0, emptyContainer.get500());
    }

    @Test
    void get1000() {
        assertEquals(6, container.get1000());
    }

    @Test
    void get1000_empty() {
        assertEquals(0, emptyContainer.get1000());
    }

    @Test
    void get2000() {
        assertEquals(8, container.get2000());
    }

    @Test
    void get2000_empty() {
        assertEquals(0, emptyContainer.get2000());
    }

    @Test
    void get5000() {
        assertEquals(10, container.get5000());
    }

    @Test
    void get5000_empty() {
        assertEquals(0, emptyContainer.get5000());
    }

    @Test
    void getMoney() {
        assertTrue(money.equals(container.getMoney()));
    }

    @Test
    void put100() {
        container.add100(10);
        assertEquals(12, container.get100());
    }

    @Test
    void put500() {
        container.add500(10);
        assertEquals(14, container.get500());
    }

    @Test
    void put1000() {
        container.add1000(10);
        assertEquals(16, container.get1000());
    }

    @Test
    void put2000() {
        container.add2000(10);
        assertEquals(18, container.get2000());
    }

    @Test
    void put5000() {
        container.add5000(10);
        assertEquals(20, container.get5000());
    }
}