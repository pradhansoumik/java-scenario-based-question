import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfAndAsList {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Apple", "Banana", "Cherry");
        //list1.add(1,"Mango"); //UnsupportedOperationException

        list1.set(1,"Mango");//updating element -> no add or removal
        System.out.println(list1);
        //list1.add(1,"Papaya"); //UnsupportedOperationException

        List<String> list2 = List.of("Grapes", "Peru", "Chiku");
        list2.set(1,"Pineapple"); //UnsupportedOperationException

    }
}
