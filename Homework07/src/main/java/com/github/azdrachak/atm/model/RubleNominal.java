package com.github.azdrachak.atm.model;

public enum RubleNominal {
    R100(100), R500(500), R1000(1000), R2000(2000), R5000(5000);
    private final int value;

    RubleNominal(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
