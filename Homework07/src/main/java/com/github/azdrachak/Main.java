package com.github.azdrachak;

import com.github.azdrachak.atm.ATM;
import com.github.azdrachak.atm.model.MoneyContainer;
import com.github.azdrachak.atm_department.ATMDepartment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("ATM Department");

        ATM atm1 = new ATM("atm1", new MoneyContainer()).addMoney(111_100);
        ATM atm2 = new ATM("atm2", new MoneyContainer()).addMoney(222_100);
        ATM atm3 = new ATM("atm3", new MoneyContainer()).addMoney(333_100);
        ATM atm4 = new ATM("atm4", new MoneyContainer()).addMoney(444_100);

        List<ATM> atms = new ArrayList<>(Arrays.asList(atm1, atm2, atm3, atm4));

        ATMDepartment department = new ATMDepartment(atms);
        System.out.println("Money in the ATMs in the beginning: " + department.getMoneySum());

        System.out.println("\nGet some money from the ATMs");
        atm1.dispenseMoney(5000);
        atm2.dispenseMoney(10500);
        atm3.dispenseMoney(100500);
        atm4.dispenseMoney(1000);
        System.out.println("Money in the ATMs: " + department.getMoneySum());

        System.out.println("\nRestore ATMs state");
        department.restoreAll();
        System.out.println("Money in the ATMs after restore: " + department.getMoneySum());
    }
}
