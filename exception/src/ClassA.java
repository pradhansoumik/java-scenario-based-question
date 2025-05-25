import java.io.FileNotFoundException;
import java.io.IOException;

public class ClassA {

    public String getMessage()
    {
        return "Hello!";
    }
    public int getNumber(){
        return 1;
    }
    public void test() throws Exception {
        System.out.println("Parent class method throwing Exception");
        throw new FileNotFoundException("Exception in A");
    }
    public void test1() throws IOException {
        System.out.println("Parent class method throwing Exception");
        throw new IOException("Exception in test1()");
    }
}
