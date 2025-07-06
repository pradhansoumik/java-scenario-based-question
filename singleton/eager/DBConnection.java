package eager;

public final class DBConnection {

    /**
     *   1. private static variable
     *      Eager initialization
     */
    private static DBConnection dbConnection = new DBConnection();

    /**
     * 2. private constructor
     */
    private DBConnection(){

    }

    /**
     * 3. public static method to get the instance
     * @return
     */
    public static DBConnection getInstance(){
        return dbConnection;
    }
}
