package billpugh;

/**
 * rectified version of eager initialization
 */
public final class DBConnection {
    /**
     * 1. private constructor
     */
    private DBConnection(){

    }

    /**
     * 2. private static inner class
     */
    private static class DBConnectionHelper{
        private static final DBConnection INSTACE_OBJECT = new DBConnection();
    }

    /**
     * 3. public static getInstance() to get the object instance;
     *
     * @return
     */
    public static DBConnection getInstance()
    {
        return DBConnectionHelper.INSTACE_OBJECT;
    }

}
