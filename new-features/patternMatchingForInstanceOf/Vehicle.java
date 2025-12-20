package patternMatchingForInstanceOf;

public interface Vehicle {
    public void drive();
}
class TwoWheeler implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a two-wheeler");
    }
}
class FourWheeler implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a four-wheeler");
    }
}
class Test{
    public static void main(String[] args) {
        //before java 17
        Object obj = new FourWheeler();

//        if (obj instanceof FourWheeler) {
//            FourWheeler fw = (FourWheeler) obj;
//            fw.drive();
//        }
//        if (obj instanceof TwoWheeler) {
//            TwoWheeler tw = (TwoWheeler) obj;
//            tw.drive();
//        }
        if(obj instanceof Vehicle){
            Vehicle vehicle = (Vehicle) obj;
            vehicle.drive();

        }
        //with java 17 and above
        Object obj1 = new TwoWheeler();
        if (obj1 instanceof Vehicle vehicle) {
            vehicle.drive();
        }
    }
}
