package com.github.azdrachak.executor;

import com.github.azdrachak.dataset.DataSet;
import com.github.azdrachak.reflection.ReflectionHelper;

import java.sql.*;

public class Executor {
    private final Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public void createUserTable() throws SQLException {
        //language=SQL
        String query = "CREATE TABLE IF NOT EXISTS `user` (" +
                " `id` BIGINT(20) NOT NULL AUTO_INCREMENT," +
                " `name` VARCHAR(255) NOT NULL DEFAULT '0'," +
                " `age` INT(3) NOT NULL DEFAULT '0'," +
                " PRIMARY KEY (`id`)" +
                ")";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
        }
    }

    public <T extends DataSet> void save(T user) throws SQLException {
        //language=SQL
        String query = "INSERT INTO `homework09`.`user` (`name`, `age`) VALUES (?, ?);";

        String name = (String) ReflectionHelper.getFieldValue(user, "name");
        int age = (int) ReflectionHelper.getFieldValue(user, "age");

        try (PreparedStatement statement = connection.prepareStatement(String.format(query, name, age))) {
            statement.setString(1, name);
            statement.setString(2, String.valueOf(age));
            statement.execute();
        }
    }

    public <T extends DataSet> T load(Long id, Class<T> clazz) throws SQLException {
        //language=SQL
        String query = "SELECT * FROM `user` WHERE `id`=?";

        String name = "";
        Integer age = 0;
        boolean hasRecord = false;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "1");
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                hasRecord = true;
                name = resultSet.getString("name");
                age = resultSet.getInt("age");
            }
            resultSet.close();
        }
        return hasRecord ? ReflectionHelper.instantiate(clazz, id, name, age) : null;
    }
}
