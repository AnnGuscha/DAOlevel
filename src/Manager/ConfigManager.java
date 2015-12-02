package Manager;

import java.util.ResourceBundle;

/**
 * Created by Anna on 12/1/2015.
 */
public class ConfigManager {

    private static ConfigManager ourInstance;

    private ConfigManager() {
        rb=ResourceBundle.getBundle("properties.mySqlConf");
    }

    public static ConfigManager getInstance()
    {
        if(ourInstance==null)
            ourInstance=new ConfigManager();
        return ourInstance;
    }
    private static ResourceBundle rb;

    public String getObject(String key)
    {
        return rb.getString(key);
    }
}