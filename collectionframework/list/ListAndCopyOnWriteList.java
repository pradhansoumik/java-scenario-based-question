import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListAndCopyOnWriteList {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();

        //List<String> list = Collections.synchronizedList(new ArrayList<>());

        list.add("Apple");
        list.add("Banana");

        //CopyOnWriteArrayList: One snapshot for the iterator (when the loop starts).

        for(String fruit: list){
            //Two new array copies — one for each add("Cherry") call.
            //modification while iteration
            list.add("Cherry");//No ConcurrentModificationException
        }
        System.out.println(list);
    }
}
