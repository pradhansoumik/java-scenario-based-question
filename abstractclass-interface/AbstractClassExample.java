public abstract class AbstractClassExample {

    public AbstractClassExample(){
        System.out.println("Def constructor: AbstractClassExample Obj created ...");
    }
    void show(){
        System.out.println("AbstractClassExample -> show()");
    }
    void display(){
        System.out.println("AbstractClassExample -> display()");
    }
    abstract void print();
}
class ChildAbstractClass extends AbstractClassExample{

    public ChildAbstractClass(){
        System.out.println("Def constructor: ChildAbstractClass Obj created ...");
    }

    @Override
    void print() {
        System.out.println("ChildAbstractClass -> print()");
    }
    void newMethod(){
        System.out.println("ChildAbstractClass -> newMethod()");
    }
}
class AnotherChildAbstractClass extends AbstractClassExample{

    @Override
    void print() {
        System.out.println("AnotherChildAbstractClass -> print()");
    }

//    @Override
//    void display() {
//        System.out.println("AnotherChildAbstractClass -> display()");
//    }
}
class TestAbstraction{
    public static void main(String[] args) {
        //can't be instantiated directly
        //AbstractClassExample obj = new AbstractClassExample();

        //ChildAbstractClass obj = new ChildAbstractClass();
        AbstractClassExample obj = new ChildAbstractClass();
        //AnotherChildAbstractClass anotherChildObj = new AnotherChildAbstractClass();

        obj.display();
        obj.show();
        obj.print();

        //anotherChildObj.print();
        //anotherChildObj.display();
//        childObj.show();
//        childObj.display();
//        childObj.print();
//        childObj.newMethod();

    }
}
