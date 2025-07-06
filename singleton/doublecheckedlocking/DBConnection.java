package doublecheckedlocking;

/**
 * To overcome synchronized initialization disadvantages (it is very slow)
 *
 */
public final class DBConnection {

    /**
     *   1. private static variable
     *   Lazy initialization
     */
    private static volatile DBConnection dbConnectionInstance;

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
    public static DBConnection getInstance()
    {
        if(dbConnectionInstance == null){
            synchronized (DBConnection.class){
                if(dbConnectionInstance == null) {
                    dbConnectionInstance = new DBConnection();
                }
            }

        }
        return dbConnectionInstance;
    }
}
