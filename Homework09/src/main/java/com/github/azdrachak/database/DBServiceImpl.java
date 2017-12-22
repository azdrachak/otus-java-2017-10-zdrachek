package com.github.azdrachak.database;

import com.github.azdrachak.dataset.DataSet;
import com.github.azdrachak.dataset.UserDataSet;
import com.github.azdrachak.executor.Executor;

import java.sql.Connection;
import java.sql.SQLException;

public class DBServiceImpl implements DBService {
    private final Connection connection;

    public DBServiceImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void prepareTables() throws SQLException {
        Executor executor = new Executor(connection);
        executor.createUserTable();
    }

    @Override
    public <T extends DataSet> void addUser(T user) throws SQLException {
        Executor executor = new Executor(connection);
        executor.save(user);
    }

    @Override
    public UserDataSet getUser(long id) throws SQLException {
        Executor executor = new Executor(connection);
        return executor.load(id, UserDataSet.class);
    }

    @Override
    public void close() throws Exception {
        connection.close();
        System.out.println("Connection closed");
    }
}
