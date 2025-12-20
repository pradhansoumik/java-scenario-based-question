package SwitchCaseEnhancement;

public class NoExhaustivenessCheck {
    public static void main(String[] args) {
        Days day = Days.MONDAY;
        /**
         * When we use Switch as an expression, compiler will force us to cover all the cases.
         * If we miss any case, it will throw a compile-time error.
         * To avoid this, we can use 'default' case to handle any missing cases.
         */
        String activity = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> "Go to Gym";
            case TUESDAY -> "Attend Dance Class";
            case THURSDAY -> "Attend Cooking Class";
            case WEDNESDAY -> "Play Football";
            //case SATURDAY -> "Do Household Chores";
            default -> "Relax at Home";
        };
    }
}
