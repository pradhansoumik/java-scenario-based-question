package synchronization;

/**
 * To overcome Lazy initialization disadvantages
 *
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
     * 3. public static synchronized method to get the instance
     * applied monitor lock for concurrency.
     * @return
     */
    synchronized public static DBConnection getInstance()
    {
        if(dbConnectionInstance == null){
            dbConnectionInstance = new DBConnection();
        }
        return dbConnectionInstance;
    }
}
