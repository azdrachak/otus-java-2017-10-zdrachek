package com.github.azdrachak;

import com.github.azdrachak.connection.ConnectionHelper;
import com.github.azdrachak.database.DBServiceImpl;
import com.github.azdrachak.dataset.UserDataSet;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(new UserDataSet(1, "Alex", 36));
        try(DBServiceImpl dbService = new DBServiceImpl(ConnectionHelper.getConnection())) {
            System.out.println("Creating table");
            dbService.prepareTables();
        }
    }
}
