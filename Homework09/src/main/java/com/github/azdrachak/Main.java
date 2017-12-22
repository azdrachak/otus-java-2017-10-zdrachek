package com.github.azdrachak;

import com.github.azdrachak.connection.ConnectionHelper;
import com.github.azdrachak.database.DBServiceImpl;
import com.github.azdrachak.dataset.UserDataSet;

public class Main {
    public static void main(String[] args) throws Exception {
        try(DBServiceImpl dbService = new DBServiceImpl(ConnectionHelper.getConnection())) {
            System.out.println("Creating table");
            dbService.prepareTables();

            System.out.println("Add record to the table");
            dbService.addUser(new UserDataSet("Ivan", 45));

            System.out.println("Read user from DB");
            UserDataSet user = dbService.getUser(1);
            System.out.println(user);
        }
    }
}
