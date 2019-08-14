package by.dulik.recordbook.validate;

public class Validate {

    private static final String NAME_REGEX = "[A-Z][a-zA-z]+([ '-][a-zA-Z]+)*";
    private static final String EMAIL_REGEX = "^[\\w_-]+(?:\\.[\\w]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final String PHONE_REGEX = "^\\s?((\\+\\d{3}[-]+\\d{2,3}[-])|(\\d{3}[-]+\\d{2,3}[-])"
            + "|(\\d{1}[-]+\\d{3}[-]))+\\d{7}\\s?";

    public static boolean checkName(String name) {
        return name.matches(NAME_REGEX);
    }

    public static boolean checkEmail(String name) {
        return name.matches(EMAIL_REGEX);
    }

    public static boolean checkPhone(String name) {
        return name.matches(PHONE_REGEX);
    }
}