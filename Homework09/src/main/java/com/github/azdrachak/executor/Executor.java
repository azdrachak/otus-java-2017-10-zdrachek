package com.github.azdrachak.executor;

import com.github.azdrachak.dataset.DataSet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Executor {
    private final Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void execQuery(String query, ResultHandler handler) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            handler.handle(resultSet);
        }
    }

    public void execUpdate(String query) throws SQLException {
        try (Statement statement = connection.createStatement();) {
            statement.execute(query);
        }
    }

    //TODO implement save to DB
    public <T extends DataSet> void save(T user) {
    }

    //TODO implement load from DB to class
    <T extends DataSet> T load(long id, Class<T> clazz) {
        return null;
    }
}
