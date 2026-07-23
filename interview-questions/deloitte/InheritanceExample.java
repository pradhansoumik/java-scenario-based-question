package deloitte;

public class InheritanceExample {
    public static void main(String[] args) {

        P p = new C();
        System.out.println(p.x); // Output: 10
        p.method1(); // Output: Method 1 in class C

        C c = (C)p;
        System.out.println(c.x); // Output: 20
        c.method1(); // Output: Method 1 in class C
        c.method2(); // Output: Method 2 in class C
    }
}
class P {

    int x = 10;
    public void method1() {
        System.out.println("Method 1 in class P");
    }
}
class C extends P {

    int x = 20;

    public void method1() {
        System.out.println("Method 1 in class C");
    }
    public void method2() {
        System.out.println("Method 2 in class C");
    }
}
