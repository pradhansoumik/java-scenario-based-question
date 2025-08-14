import java.util.HashMap;
import java.util.Map;

public class HashMapMain{
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();

        // doesn't maintain insertion order!
        map.put(1,"Soumik");
        map.put(2,"Supriti");
        map.put(3,"Chiku");
        map.put(4,"Rumki");
        map.put(5,"ABC");
        map.put(6,"XYZ");
        map.put(10,"Hey Chiku");
        map.put(7,"Hey Rumki");
        map.put(8,"Hey Rig");
        map.put(12,"Hey Kocho");
        map.put(12,"Hey Kocho");
        System.out.println("1. INSERTION ORDER TEST : "+map);

        // NULL key Test!
        // Only 1 NULL key is allowed, even if we give multiple null keys but
        // Only the last inserted value for null key remains.!
        // All null keys map to the bucket at index 0 (because null has no hashcode).
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(null,"NullKey1");
        map1.put(null,"NullKey2");
        map1.put(null,"NullKey3");//it will print only
        System.out.println("2. NULL KEY ALLOWED TEST : "+map1);
        System.out.println("2. NULL KEY ALLOWED TEST : "+map1.get(null));

        // duplicate keys Test!
        // if we insert an entry with a key that already exists, the new value will overwrite the old one.
        // duplicate keys are not allowed, but inserting a duplicate will replace the existing value.
        // Only one entry per unique key is stored.
        // HashMap first uses hashCode() to find the bucket,
        // then uses equals() to check if the key is a duplicate within that bucket & update the value.
        Map<Integer, String> map2 = new HashMap<>();
        map2.put(101,"DuplicateVal1");
        map2.put(101,"DuplicateVal2");
        map2.put(101,"DuplicateVal3");//it will print only
        System.out.println("3. DUPLICATE KEY TEST : "+map2);

        // Keys are case sensitive Test!
        Map<String, String> map3 = new HashMap<>();
        map3.put("apple", "fruit");
        map3.put("Apple", "company");

        System.out.println("4. KEY CASE SENSITIVE TEST : "+map3);
        //System.out.println(map3.get("apple")); // fruit
        //System.out.println(map3.get("Apple")); // company

        // Key is not present Test!
        System.out.println("5. +++ KEY NOT PRESENT TEST +++ ");
        System.out.println(map3.get("Carrot"));//null
        System.out.println(map2.get("Carrot"));//null even we change the data type
        System.out.println(map1.get(0));//null
        System.out.println(map.get("1"));//null
    }
}
