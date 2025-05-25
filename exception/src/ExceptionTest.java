import java.io.IOException;

public class ExceptionTest {
    public static void main(String[] args) throws IOException {
        ClassB bObj = new ClassB();
        System.out.println(bObj.getNumber());

        System.out.println(bObj.getMessage());

        bObj.test();
    }
}