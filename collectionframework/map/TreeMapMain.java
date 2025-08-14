import java.util.TreeMap;

public class TreeMapMain {
    public static void main(String[] args) {

        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(25,"Entry 25");
        treeMap.put(30,"Entry 30");
        treeMap.put(15,"Entry 15");
        treeMap.put(25,"Entry 25 updated");

        treeMap.forEach((key,value)-> System.out.println(key +" : "+value));

    }
}
