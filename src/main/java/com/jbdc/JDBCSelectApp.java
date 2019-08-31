package com.jbdc;

import java.sql.*;

public class JDBCSelectApp
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
            String sql = "SELECT COUNTRY_NAME FROM countries WHERE COUNTRY_NAME LIKE 'A%'";
            ResultSet resultSet = statement.executeQuery(sql);

            String countryName;
            while (resultSet.next())
            {
                countryName = resultSet.getString(1);
                System.out.println(countryName);
            }
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
