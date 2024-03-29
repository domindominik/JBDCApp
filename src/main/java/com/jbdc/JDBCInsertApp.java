package com.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsertApp
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
            String sql = "INSERT INTO countries (COUNTRY_ID, COUNTRY_NAME, REGION_ID) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);


            statement.setString(1, "po");
            statement.setString(2, "polska");
            statement.setInt(3, 2);

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
