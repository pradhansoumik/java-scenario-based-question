import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Object> nameList = new ArrayList<>();
        nameList.add("Soumik P");
        nameList.add("Supriti M");

        MyImmutableClass myImmutableClass = new MyImmutableClass("myName",nameList);
        nameList.add("Hello I am breaking immutability through constructor");
        myImmutableClass.getNameList().add("Hello I am breaking immutability through getter");

        System.out.println(myImmutableClass.getNameList());
    }
}