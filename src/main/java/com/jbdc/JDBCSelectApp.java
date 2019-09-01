package com.jbdc;

import com.jbdc.dbcore.DatabaseManager;
import com.jbdc.dbcore.MySQLJBDCConnectionManager;

import java.sql.*;
import java.util.List;

public class JDBCSelectApp
{
    public static void main(String[] args)
    {
        DatabaseManager databaseManager = new MySQLJBDCConnectionManager("company_db", "company", "company");
        try
        {
            List<String> resultList = databaseManager.executeSelect("SELECT COUNTRY_NAME FROM countries WHERE COUNTRY_NAME LIKE 'A%'");
            for (String value: resultList)
            {
                System.out.println(value);
            }
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
