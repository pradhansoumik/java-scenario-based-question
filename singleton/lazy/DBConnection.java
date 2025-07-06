package lazy;

/**
 * Lazy initialization
 * disadvantage is that if two threads tries to get the object at the same time
 * the object is null hence two objects will be created.
 */
public final class DBConnection {

    /**
     *   1. private static variable
     *   Lazy initialization
     */
    private static DBConnection dbConnectionInstance;

    /**
     * 2. private constructor
     */
    private DBConnection(){

    }

    /**
     * 3. public static method to get the instance
     * @return
     */
    public static DBConnection getInstance()
    {
        if(dbConnectionInstance == null){
            dbConnectionInstance = new DBConnection();
        }
        return dbConnectionInstance;
    }
}
