package com.jbdc.dbcore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLJBDConnectionProvider implements ConnectionProvider
{
    @Override
    public Connection createLocalConnections(String dbName, String user, String password) throws Exception {
        Connection connection = null;
        String errorMessage = "";
        try
        {
           connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/" + dbName,
                user,
                password);
        }
        catch (SQLException e)
        {
            errorMessage = "SQL Error: " + e.getSQLState() + " message: " + e.getMessage();
        }
        catch (Exception e)
        {
            errorMessage = "Exceptions: " + e.getMessage();
        }
        if (connection == null)
        {
            throw new Exception(errorMessage);
        }
        return connection;
    }
}
