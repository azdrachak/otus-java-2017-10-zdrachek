package com.github.azdrachak.atm.memento;

import com.github.azdrachak.atm.ATM;
import com.github.azdrachak.atm.model.MoneyContainer;
import com.github.azdrachak.atm.model.RubleNominal;

import java.util.HashMap;

public class Originator {

    public ATM getMemento(Memento memento) {
        return memento.getSavedState();
    }

    public Memento addMemento(ATM atm) {
        return new Memento(atm);
    }

    public class Memento {
        private HashMap<RubleNominal, Integer> money;
        private String id;

        @SuppressWarnings("unchecked")
        Memento(ATM atm) {
            this.id = atm.getId();
            this.money = (HashMap<RubleNominal, Integer>) atm.getMoney().clone();
        }

        ATM getSavedState() {
            return new ATM(id, new MoneyContainer(money));
        }
    }
}
