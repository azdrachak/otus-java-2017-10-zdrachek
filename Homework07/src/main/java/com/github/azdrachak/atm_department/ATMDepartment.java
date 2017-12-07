package com.github.azdrachak.atm_department;

import com.github.azdrachak.atm.ATM;

import java.util.List;

public class ATMDepartment {
    private List<ATM> atms;

    public ATMDepartment(List<ATM> atms) {
        this.atms = atms;
    }

    public int getMoneySum() {
        return atms.stream().map(ATM::getRemainingMoney).mapToInt(Integer::intValue).sum();
    }

    public void restore() {
        System.out.println("ATMs are restored to the initial state");
    }
}
