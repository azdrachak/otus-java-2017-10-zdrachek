package com.github.azdrachak.database;

import com.github.azdrachak.dataset.UserDataSet;

import java.sql.SQLException;
import java.util.List;

public interface DBService extends AutoCloseable {
    void prepareTables() throws SQLException;

    void addUser(long id, String name, int age) throws SQLException;

    String getUserName(long id) throws SQLException;

    UserDataSet getUser(long id) throws SQLException;

    List<UserDataSet> getAllUsers() throws SQLException;
}
