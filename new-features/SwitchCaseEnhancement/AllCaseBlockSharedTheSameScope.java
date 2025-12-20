package SwitchCaseEnhancement;

public class AllCaseBlockSharedTheSameScope {

    public static void main(String[] args) {
        // Before Java 14
        /**
         * issue - Variable 'hours' is already defined in the scope
         * solution - use block {} for each case block - means segregate each case block.
         */
        Days day = Days.MONDAY;
        switch (day) {

            case MONDAY: {
                int hours = 8;
                System.out.println("Working hours: " + hours);
                break;
            }
            case TUESDAY:
                int hours = 8;
                System.out.println("Working hours: " + hours);
                break;
            default:
                System.out.println("Weekend!");
        }

        // After Java 14
        Days day2 = Days.MONDAY;
        String msg = switch (day2) {
            case MONDAY -> {
                int hours = 8;
                yield "Working hours: " + hours;
            }
            case TUESDAY -> {
                int hours = 8;
                yield "Working hours: " + hours;
            }
            default -> "Weekend!";
        };
    }

}
