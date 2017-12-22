package com.github.azdrachak.database;

import com.github.azdrachak.dataset.DataSet;
import com.github.azdrachak.dataset.UserDataSet;

import java.sql.SQLException;

public interface DBService extends AutoCloseable {
    void prepareTables() throws SQLException;

    <T extends DataSet> void addUser(T user) throws SQLException;

    UserDataSet getUser(long id) throws SQLException;
}
