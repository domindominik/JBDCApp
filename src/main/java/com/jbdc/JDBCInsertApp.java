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
            String sql ="INSERT INTO locations (LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID) VALUES ('666', 'Rynek 48 Wroclaw', '50-116','Twierdza Wroclaw', 'Phuket', '2');";
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
