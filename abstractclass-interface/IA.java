public interface IA {
    void m1();
}
interface IB extends IA {
    void m2();
}
class IC implements IB {

    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }
}
