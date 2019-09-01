package com.jbdc.dbcore;

import java.sql.Connection;

public interface ConnectionProvider
{
    Connection createLocalConnections(String dbname, String user, String password) throws Exception;
}
