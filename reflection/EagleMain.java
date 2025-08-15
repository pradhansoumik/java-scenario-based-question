import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EagleMain {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class clazz = Eagle.class;

        //it will get only All public methods from current class & super class as well!
        Method[] getAllPublicMethods = clazz.getMethods();

        for(Method m : getAllPublicMethods){
            System.out.println("public Method: "+m.getName());
        }

        // it will get all public & private methods from current class only &
        // NOT from any super class [Remember]!
        Method[] getAllPublicAndPrivateMethods = clazz.getDeclaredMethods();
        for(Method method : getAllPublicAndPrivateMethods){
            System.out.println("public & private Method: "+method.getName());
        }

        /**
         * Method invocation
         */
        //calling method with no args
        Method m = clazz.getMethod("eat");
        m.invoke(new Eagle());

        //calling public method with args
        Method swimObj = clazz.getMethod("swim", boolean.class, String.class, int.class);
        swimObj.invoke(new Eagle(),true,"can't swim",10);

        //calling public/private method with args
        Method beatObj = clazz.getDeclaredMethod("beat", boolean.class, String.class, int.class);
        beatObj.setAccessible(true); //key point to remember
        //Object obj = clazz.newInstance();// before java 9
        Object obj = clazz.getDeclaredConstructor().newInstance();//java 9+
        Object retVal = beatObj.invoke(obj,true,"can beat",10);
        System.out.println(retVal);

        /**
         * Reflection Of Fields ...
         */
        Field field1 = clazz.getDeclaredField("canTalk");
        Field field2 = clazz.getDeclaredField("breed");

        Eagle eagleObj = new Eagle();
        field1.set(eagleObj,true);
        System.out.println("1. printing talk new value: "+eagleObj.canTalk);

        Object fieldObj = clazz.getDeclaredConstructor().newInstance();
        field2.setAccessible(true);
        //Fields can be private or public BUT NOT final, as it will not change the value for final!
        //for private you will get o/p => new breed but for final value won't get updated.
        field2.set(eagleObj,"new breed");
        System.out.println("2. printing breed new value: "+ eagleObj.getBreed());

    }
}
