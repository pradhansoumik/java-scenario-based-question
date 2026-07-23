package dell;

public class DiamondProblem {
    public static void main(String[] args) {

    }
}
class A {
    public void method() {
        System.out.println("Method in class A");
    }
}
class B {
    public void method() {
        System.out.println("Method in class B");
    }
}
/*class C extends A, B {
        // This will cause a compilation error due to ambiguity
        // The compiler won't know which method to call (A's or B's)
}*/

interface A1 {
    public void method1();
    public void method2();
}
interface B1 {
    public void method1();
    public void method3();
}
class C1 implements A1, B1 {
    @Override
    public void method1() {
        System.out.println("Method 1 in class C1");
    }

    @Override
    public void method2() {
        System.out.println("Method 2 in class C1");
    }

    @Override
    public void method3() {
        System.out.println("Method 3 in class C1");
    }
}

/*                     */
class d1{
    public void method1(){
        System.out.println("Method 1 in class d1");
    }
    public void method2(){
        System.out.println("Method 2 in class d1");
    }
}
class d2{
    public void method3(){
        System.out.println("Method 1 in class d2");
    }
    public void method4(){
        System.out.println("Method 3 in class d2");
    }
}
/*class c2 extends d1, d2{
    // This will cause a compilation error due to ambiguity
    // The compiler won't know which method to call (d1's or d2's)
}*/




/*   This is how Java resolves the diamond problem with interfaces. */
interface A2 {
    default void method1() {
        System.out.println("Default Method 1 in interface A2");
    }
    public void method2();
}
interface B2 {
    default void method1() {
        System.out.println("Default Method 1 in interface B2");
    }
    public void method3();
}
class C2 implements A2, B2 {
    @Override
    public void method1() {
        System.out.println("Overridden Method 1 in class C2");
        A2.super.method1(); // Call A2's default method
        B2.super.method1(); // Call B2's default method
    }

    @Override
    public void method2() {
        System.out.println("Method 2 in class C2");
    }

    @Override
    public void method3() {
        System.out.println("Method 3 in class C2");
    }
}

