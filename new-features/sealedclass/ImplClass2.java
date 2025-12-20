package sealedclass;

public non-sealed class ImplClass2 implements SealedInterface {

    @Override
    public void m1() {
        System.out.println("ImplClass2 m1 method");
    }
}
