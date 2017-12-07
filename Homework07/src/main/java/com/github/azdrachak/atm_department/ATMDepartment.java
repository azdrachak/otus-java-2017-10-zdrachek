package com.github.azdrachak.atm_department;

import com.github.azdrachak.atm.ATM;
import com.github.azdrachak.atm.memento.Originator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATMDepartment {
    private List<ATM> atms;
    private Map<String, Originator.Memento> stateKeeper = new HashMap<>();
    private Originator originator = new Originator();

    public ATMDepartment(List<ATM> atms) {
        this.atms = atms;
        atms.forEach(atm -> stateKeeper.put(atm.getId(), originator.addMemento(atm)));
    }

    public int getMoneySum() {
        return atms.stream().map(ATM::getRemainingMoney).mapToInt(Integer::intValue).sum();
    }

    public void restoreAll() {
        for (int i = 0; i < atms.size(); i++) {
            ATM atm = atms.get(i);
            atms.set(i, originator.getMemento(stateKeeper.get(atm.getId()))) ;
        }
        System.out.println("ATMs are restored to the initial state");
    }

    public void restoreById(String id) {
        System.out.println("Restored " + id);
    }
}
