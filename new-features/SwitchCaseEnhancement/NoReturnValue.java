package SwitchCaseEnhancement;

public class NoReturnValue {
    public static void main(String[] args) {
        Days day = Days.MONDAY;
        int count = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY                -> 7;
            case THURSDAY, SATURDAY     -> 8;
            case WEDNESDAY              -> 9;
        };
        System.out.println("Number of letters in " + day + " is " + count);

        /**
         * yield statement in switch case
         */
        Days anotherDay = Days.SUNDAY;
        int newCount = switch (anotherDay) {
            case MONDAY, FRIDAY, SUNDAY -> {
                if(anotherDay == Days.SUNDAY){
                    System.out.println("It's Holiday!");
                }
                yield 6;
            }
            case TUESDAY                -> 7;
            case THURSDAY, SATURDAY     -> 8;
            case WEDNESDAY              -> 9;
        };
        System.out.println("Number of letters in " + anotherDay + " is " + newCount);
    }
}
