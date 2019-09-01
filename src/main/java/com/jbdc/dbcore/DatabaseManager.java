package com.jbdc.dbcore;

import java.util.List;

public interface DatabaseManager
{
    List<String> executeSelect(String sql) throws Exception;
    void executeUpdate(String sql);
}
