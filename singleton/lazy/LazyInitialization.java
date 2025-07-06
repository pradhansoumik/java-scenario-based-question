package lazy;

public class LazyInitialization {
    public static void main(String[] args)
    {
        DBConnection instance = DBConnection.getInstance();
    }
}
