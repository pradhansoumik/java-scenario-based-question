import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakSingletone {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        try {
            SingletoneClass s1 = SingletoneClass.getInstance();
            System.out.println("First instance hashcode: " + s1.hashCode());
            Constructor<SingletoneClass> constructor = SingletoneClass.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            SingletoneClass s2 = constructor.newInstance();
            System.out.println("Second instance hashcode: " + s2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class SingletoneClass{
    private static SingletoneClass instance;
    private SingletoneClass() throws Exception {

        if (instance != null) {
            throw new Exception("Use getInstance() method ...");
        }
        System.out.println("private constructor of SingletoneClass");
    }
    public static SingletoneClass getInstance() throws Exception {
        if(instance == null){
            instance = new SingletoneClass();
        }
        return instance;
    }
}
