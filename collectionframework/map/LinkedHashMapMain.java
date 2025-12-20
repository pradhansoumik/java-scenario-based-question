import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapMain {
    public static void main(String[] args) {

        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        // maintain insertion order!
        map.put("first","Soumik");
        map.put("2nd","Supriti");
        map.put("3rd","Chiku");
        map.put("4th","Rumki");
        map.put("5th","ABC");
        map.put("6th","XYZ");
        map.put("10th","Hey Chiku");
        map.put("7th","Hey Rumki");
        map.put("8th","Hey Rig");
        map.put("12th","Hey Kocho");
        map.put("12th","Hey Kocho updated");

        //System.out.println("1. INSERTION ORDER TEST : "+map);
        System.out.println("INSERTION ORDER IS PRESERVED IN LINKED HASH MAP");

        /*for(Map.Entry<String, String > singleMap: map.entrySet()){
            System.out.println("Printing through for loop: "+singleMap.getValue());
        }*/

        /**
         * it maintains access order - means
         * (most recently accessed entries move to the end). This is often used for LRU caches.
         *
         * It’s about recency of access, not frequency. not the order in which they were added.
         * An LRU cache removes the least recently used element when the cache is full,
         * keeping the most recently accessed elements available.
         */
        LinkedHashMap<Integer, String> map1 =
                new LinkedHashMap<>(16, 0.75f, true); // true = access order

        map1.put(1, "One");
        map1.put(2, "Two");
        map1.put(3, "Three");

        // Access key 1 (this moves key 1 to the end)
        map1.get(1);

        for (Map.Entry<Integer, String> e : map1.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}
