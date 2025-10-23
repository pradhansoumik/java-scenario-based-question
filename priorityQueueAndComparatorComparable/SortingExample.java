import java.util.Arrays;
import java.util.Comparator;

public class SortingExample {
    public static void main(String[] args) {
        Integer[] arr = {5,3,8,1,2};
        /**
         * primitive collection sorting
         */
        Arrays.sort(arr);// sorts in ascending order. quick sort
        //System.out.println("Natural Sorted array: " + Arrays.toString(arr));

        Arrays.sort(arr, (Integer a, Integer b) -> b - a);// sorts in descending order
        //System.out.println("Descending Sorted array: " +Arrays.toString(arr));

        /**
         * Object collection sorting
         */
        Car[] cars = {
                new Car("Toyota", "Suv"),
                new Car("Honda", "City"),
                new Car("Ford", "Sports")
        };

        //Arrays.sort(cars);

        //System.out.println("Sorted cars by model: " + Arrays.toString(cars));

        //Arrays.sort(cars, (Car a, Car b) -> a.carType.compareTo(b.carType));

        //Arrays.sort(cars, Comparator.comparing((Car a) -> a.carType));

        //Arrays.sort(cars, (Car a, Car b) -> a.carName.compareTo(b.carName));

        //Arrays.sort(cars, new Car());//comparator
        Comparator<Car> byType = Comparator.comparing(car -> car.carType);
        Comparator<Car> byName = Comparator.comparing(car -> car.carName);

        //Arrays.sort(cars);//comparable

        Arrays.sort(cars, byType);
        Arrays.sort(cars, byName);

        System.out.println("Sorted cars by model: " + Arrays.toString(cars));
    }
}
