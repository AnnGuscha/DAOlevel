package manager;

import java.util.ResourceBundle;

/**
 * Created by Anna on 12/1/2015.
 */
public class ManagerMySqlQueries {
    private static ManagerMySqlQueries ourInstance = new ManagerMySqlQueries();
    private static ResourceBundle rb;

    private ManagerMySqlQueries() {
        rb = ResourceBundle.getBundle("properties.mySqlConf");
    }

    public static ManagerMySqlQueries getInstance() {
        if(ourInstance==null)
            ourInstance=new ManagerMySqlQueries();
        return ourInstance;
    }

    public String getObject(String key)
    {
        return rb.getString(key);
    }
}