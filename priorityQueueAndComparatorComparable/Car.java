import java.util.Comparator;

public class Car implements Comparable<Car> {
    String carName;
    String carType;

    public Car(String carname, String cartype){
        this.carName = carname;
        this.carType = cartype;
    }
    public Car(){

    }

    @Override
    public String toString() {
        return carName+"-"+carType;
    }

//    @Override
//    public int compare(Car o1, Car o2) {
//        return o1.carType.compareTo(o2.carType);
//    }

    @Override
    public int compareTo(Car o) {
        return o.carType.compareTo(this.carType);
    }
}
