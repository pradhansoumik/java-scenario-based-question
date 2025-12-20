package SwitchCaseEnhancement;

public class MultipleCaseStaking {
    public static void main(String[] args) {
        /**
         * Earlier each case needs its own line;
         * now multiple cases can be stacked with commas separated grouping.
         */
        Days day = Days.FRIDAY;
        switch (day) {
            case MONDAY, WEDNESDAY, FRIDAY -> System.out.println("You have a Math class.");
            case TUESDAY, THURSDAY -> System.out.println("You have a Science class.");
            case SATURDAY, SUNDAY -> System.out.println("It's the weekend! No classes.");
        }
    }
}
