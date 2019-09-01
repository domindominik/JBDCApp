package com.jbdc;

import com.jbdc.dbcore.DatabaseManager;
import com.jbdc.dbcore.MySQLJBDCConnectionManager;

public class JDBCUpdateApp3
{
    public static void main(String[] args)
    {
        DatabaseManager databaseManager = new MySQLJBDCConnectionManager("company_db", "company", "company");
        try
        {
            databaseManager.executeUpdate("UPDATE employees SET SALARY = 55299 WHERE FIRST_NAME ='David' AND LAST_NAME = 'Austin'");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
