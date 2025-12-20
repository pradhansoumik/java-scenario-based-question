package patternMatchingForInstanceOf;

public class PatternMatchingForInstanceOfExample {
    public static void main(String[] args) {

        //before java 16
        //With old way, there is an extra overhead of doing this typecasting.
        //Which is now resolved through this Java 16 pattern matching feature.
        //This eliminates boilerplate casting and makes the code more concise and readable.
        Object obj = "Hello, Pattern Matching!";

        if(obj instanceof String){
            String str = (String) obj;//explicit type casting
            System.out.println("String length before java 17: " + str.length());
        }

        //with java 16 and above
        //compiler ensures the type safety and does the type casting internally.
        //first comparison happens & then str is automatically type cast and initialized
        if(obj instanceof String str){
            //str does only exist inside the block only.
            System.out.println("String length after java 17: " + str.length());
        }

        /**
         * we can combine it with && operator
         */
        Object obj2 = 10;
        if(obj2 instanceof Integer num && num > 5){
            System.out.println("The number is greater than 5: " + num);
        }
        //not possible as comparison needs to be happened first then it will be automatically
        //type casted & then further used for some condition
        /*else if(num  <5 && obj2 instanceof Integer num){
            System.out.println("The number is 5 or less.");
        }*/

        /**
         * But pattern matching does not work in combination with '||' operator
         */
        Object obj3 = "Test String";
        if(obj3 instanceof String str1 || obj3 instanceof Integer i) {
            //This will give compilation error as 'str1' may not have been initialized
            //System.out.println("Value: " + str1);
        }
    }
}
