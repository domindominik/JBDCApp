package com.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdateApp
{
    public static void main(String[] args)
    {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://127.0.0.1:3306/company_db",
                "company",
                "company"))
        {
            if (connection != null)
            {
                System.out.println("Connection created successfully!");
            }
            else
            {
                System.out.println("Connection creation failed!");
            }
            Statement statement = connection.createStatement();
            String sql ="UPDATE employees SET SALARY = 15200 WHERE FIRST_NAME ='David' AND LAST_NAME = 'Austin'";
            statement.executeUpdate(sql);
        }
        catch (SQLException e)
        {
            System.out.println(e.getSQLState() + " message: " + e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
