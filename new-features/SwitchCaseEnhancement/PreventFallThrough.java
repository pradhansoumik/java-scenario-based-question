package SwitchCaseEnhancement;

public class PreventFallThrough {
    public static void main(String[] args) {
        //earlier versions of Java required explicit break statements to prevent fall-through in switch cases.
        Days day = Days.MONDAY;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                System.out.println(6);
                //break; /* missed break statement so, it will fall back to the next case. */
            case TUESDAY:
                System.out.println(7);
                break;
            case THURSDAY:
            case SATURDAY:
                System.out.println(8);
                break;
            case WEDNESDAY:
                System.out.println(9);
                break;
        }


        // NOW, with the enhanced switch expressions in Java 12 and later, you can use the "arrow" syntax (->)
        // no break statements are needed, and fall-through is prevented by default.
        Days days = Days.MONDAY;
        switch (days) {
            case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
            case TUESDAY                -> System.out.println(7);
            case THURSDAY, SATURDAY     -> System.out.println(8);
            case WEDNESDAY              -> System.out.println(9);
        }
    }
}
