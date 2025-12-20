package SwitchCaseEnhancement;

public class CaseLabelStyle {
    public static void main(String[] args) {
        String day = "MONDAY";
        // Old Style
        /**
         * case L: , OR, case L, L, L:
         */

        /**
         * case L -> , OR, case L, L, L ->
         * if we are using colon : then it will 'fall-through' so,
         * use break; or return; (yield) to avoid fall-through
         * however,
         * with arrow new style -> it will not 'fall-through'
         */
        String result = switch (day) {
            case "MONDAY", "FRIDAY", "SUNDAY" : yield "6 AM";
            case "TUESDAY" : yield  "7 AM";
            case "THURSDAY", "SATURDAY" : yield "8 AM";
            case "WEDNESDAY" : yield "9 AM";
            default : yield  "Holiday";
        };
        System.out.println("Wake up at: " + result);
    }
}
