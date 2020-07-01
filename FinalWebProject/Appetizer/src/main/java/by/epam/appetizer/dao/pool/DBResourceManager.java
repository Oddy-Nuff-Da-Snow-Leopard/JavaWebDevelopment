package by.epam.appetizer.dao.pool;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public final class DBResourceManager {

    private static final DBResourceManager INSTANCE = new DBResourceManager();

    private DBResourceManager() {
    }

    public static DBResourceManager getInstance() {
        return INSTANCE;
    }

    private final ResourceBundle bundle = PropertyResourceBundle.getBundle("db");

    public String getValue(String key) {
        return bundle.getString(key);
    }
}
