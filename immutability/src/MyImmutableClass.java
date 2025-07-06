import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MyImmutableClass {
    private final String name;
    private final List<Object> nameList;

    public MyImmutableClass(String name, List<Object> nameList){
        this.name = name;
        //this.nameList = nameList;
        // Defensive copy to protect internal state
        this.nameList = new ArrayList<>(nameList);
    }
    public String getName() {
        return name;
    }

    public List<Object> getNameList() {
        // Defensive copy to protect internal state
        return new ArrayList<>(nameList);
        //return nameList;
        //return Collections.unmodifiableList(nameList);
    }
}
