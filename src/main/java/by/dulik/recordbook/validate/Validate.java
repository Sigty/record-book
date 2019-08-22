package by.dulik.recordbook.validate;

public class Validate {

    public static final String NUMBER_REGEX = "[0-9]$";
    public static final String PHONE_REGEX = "^((375)\\d{2}[ ])+\\d{7}$";
    public static final String NAME_REGEX = "[A-Z][a-zA-z]+([ '-][a-zA-Z]+)*";
    public static final String ROLE_REGEX = "[a-zA-z]+([ '-][a-zA-Z]+)*";
    public static final String EMAIL_REGEX = "[a-zA-Z0-9]*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{1,6}$";

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