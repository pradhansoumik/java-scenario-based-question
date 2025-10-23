public interface InterfaceExample {
    void method1();
    void method2();
    default void method3() {
        System.out.println("This is a default method in the interface.");
    }
    static void utility() {
        System.out.println("This is a static method in the interface.");
    }
}
interface InterfaceExample1 extends InterfaceExample {
    void methodA();
    void methodB();
    default void methodC() {
        System.out.println("This is a default method in InterfaceExample1.");
    }
}
class A implements InterfaceExample1 {

    public void method1() {
        System.out.println("Implementation of method1 in class A");
    }

    public void method2() {
        System.out.println("Implementation of method2 in class A");
    }

    @Override
    public void methodA() {
        System.out.println("Implementation of methodA in class A");
    }

    @Override
    public void methodB() {
        System.out.println("Implementation of methodB in class A");
    }
}
class TestInterface{
    public static void main(String[] args) {
        A obj = new A();
        obj.method1();
        obj.method2();
        obj.method3(); // Calling default method from InterfaceExample
        obj.methodC(); // Calling default method from InterfaceExample1
        InterfaceExample.utility(); // Calling static method from InterfaceExample
    }
}
