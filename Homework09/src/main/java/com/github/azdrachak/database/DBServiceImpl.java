package com.github.azdrachak.database;

import com.github.azdrachak.dataset.UserDataSet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBServiceImpl implements DBService {
    private final Connection connection;
    private final String CREATE_TABLE_IF_NOT_EXISTS = "CREATE TABLE IF NOT EXISTS `user` (" +
                                                      " `id` BIGINT(20) NOT NULL AUTO_INCREMENT," +
                                                      " `name` VARCHAR(255) NOT NULL DEFAULT '0'," +
                                                      " `age` INT(3) NOT NULL DEFAULT '0'," +
                                                      " PRIMARY KEY (`id`)" +
                                                      ")";
    private final String SELECT_ALL_USERS = "SELECT * FROM `user`";
    private final String SELECT_USER_BY_ID = "SELECT * FROM `user` WHERE `id`=%s";

    DBServiceImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void prepareTables() throws SQLException {

    }

    @Override
    public void addUser(long id, String name, int age) throws SQLException {

    }

    @Override
    public String getUserName(long id) throws SQLException {
        return null;
    }

    @Override
    public UserDataSet getUser(long id) throws SQLException {
        return null;
    }

    @Override
    public List<UserDataSet> getAllUsers() throws SQLException {
        return null;
    }

    @Override
    public void close() throws Exception {
        connection.close();
        System.out.println("Connection closed");
    }
}
