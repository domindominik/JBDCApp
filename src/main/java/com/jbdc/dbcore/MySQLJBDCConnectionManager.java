package com.jbdc.dbcore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLJBDCConnectionManager implements DatabaseManager
{
    private ConnectionProvider connectionProvider;
    private String database;
    private String user;
    private String password;

    public MySQLJBDCConnectionManager(String database, String user, String password) {
        this.connectionProvider = new MySQLJBDConnectionProvider();
        this.database = database;
        this.user = user;
        this.password = password;
    }

    @Override
    public List<String> executeSelect(String sql) throws Exception
    {
        List<String> resultList = new ArrayList<>();
        try (Connection connection = connectionProvider.createLocalConnections(database, user, password))
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next())
            {
                resultList.add(resultSet.getString(1));
            }
        }
        return resultList;
    }

    @Override
    public void executeUpdate(String sql)
    {

    }
}
