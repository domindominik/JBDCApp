package com.jbdc;

import java.sql.*;

public class JDBCUpdateApp2
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
            String sql ="UPDATE employees SET SALARY = ? WHERE FIRST_NAME = ? AND LAST_NAME = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, 23456);
            statement.setString(2, "David");
            statement.setString(3, "Austin");

            statement.executeUpdate();
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
