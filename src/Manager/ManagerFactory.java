package manager;

import java.util.HashMap;
import java.util.Map;

public class ManagerFactory {

    private static Map<Locale, MessageManager> bundleMap=new HashMap<>();

    private ManagerFactory() {
    }

    public static MessageManager getMessageManager() {
        if (!bundleMap.containsKey(Locale.DEFAULT))
            bundleMap.put(Locale.DEFAULT, new MessageManager());
        return bundleMap.get(Locale.DEFAULT);
    }

    public static MessageManager getMessageManager(Locale locale){
        if (!bundleMap.containsKey(locale))
            bundleMap.put(locale, new MessageManager(new java.util.Locale(locale.getLanguage(),locale.getCountry())));
        return bundleMap.get(locale);
    }
}
