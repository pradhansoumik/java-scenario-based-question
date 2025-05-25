import java.io.FileNotFoundException;
import java.io.IOException;

public class ClassB extends ClassA{

    /**
     * Checked exceptions (e.g., IOException, SQLException): If the parent class method declares that it throws a checked exception,
     * the child class method must either throw the same exception, a subclass of that exception, or no exception at all.
     * The subclass cannot throw a broader checked exception than the parent class method.
     * ++++++
     * Unchecked exceptions (e.g., ArithmeticException, NullPointerException): These exceptions are subclasses of RuntimeException,
     * and they are not subject to the same rules as checked exceptions.
     * A subclass method can throw an unchecked exception even if the parent method does not, and vice versa.
     * @return
     */
    @Override
    public int getNumber(){
        return super.getNumber();
    }

    @Override
    public void test() throws IOException {
        System.out.println("inside child class overriden method");
    }

//    @Override
//    public void test1() throws Exception{
//
//    }
}
