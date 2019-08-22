package by.dulik.recordbook.util;

import by.dulik.recordbook.entity.PhoneNumber;
import by.dulik.recordbook.entity.Role;
import by.dulik.recordbook.validate.Validate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputScannerUtil {

    private static InputScannerUtil instance;

    public static synchronized InputScannerUtil getInstance() {
        if (instance == null) {
            instance = new InputScannerUtil();
        }
        return instance;
    }

    private InputScannerUtil() {
    }

    public String inputFirstName(Scanner scanner) {
        System.out.print(Message.FIRST_NAME);
        return checkName(scanner);
    }

    public String inputLastName(Scanner scanner) {
        System.out.print(Message.LAST_NAME);
        return checkName(scanner);
    }

    public String inputEmail(Scanner scanner) {
        System.out.print("Enter e-mail. Format ****@***.**** : ");
        return checkEmail(scanner);
    }

    public ArrayList<Role> inputRoles(Scanner scanner) {
        System.out.println("Enter roles: ");
        String[] rolesArray = checkList(scanner, Validate.ROLE_REGEX, Message.INVALID_INPUT);
        ArrayList<Role> roles = new ArrayList<>();
        Arrays.stream(rolesArray).forEach(role -> roles.add(new Role(role)));
        return roles;
    }

    public ArrayList<PhoneNumber> inputPhones(Scanner scanner) {
        System.out.print("Enter phone numbers. Format 375** ******* : ");
        String[] phonesArray = checkList(scanner, Validate.PHONE_REGEX, Message.INVALID_PHONE);
        ArrayList<PhoneNumber> phones = new ArrayList<>();
        Arrays.stream(phonesArray).forEach(n -> phones.add(new PhoneNumber(n)));
        return phones;
    }

    public String[] inputFullName(Scanner scanner) {
        String[] result = new String[2];
        System.out.print(Message.FIRST_NAME);
        result[0] = checkName(scanner).trim();
        System.out.print(Message.LAST_NAME);
        result[1] = checkName(scanner).trim();
        return result;
    }

    public static String checkName(Scanner scanner) {
        return getString(scanner, Validate.NAME_REGEX);
    }

    public static String checkEmail(Scanner scanner) {
        return getString(scanner, Validate.EMAIL_REGEX);
    }

    public static String checkRegex(Scanner scanner, String regex, String warning) {
        return getPhoneRegex(scanner, regex, warning);
    }

    public static int checkNumberLength(Scanner scanner, String regex) {
        return getNumber(scanner, regex);
    }

    public static String[] checkList(Scanner scanner, String regex, String warning) {
        String input;
        boolean unique;
        int quality = checkNumberLength(scanner, Validate.NUMBER_REGEX);
        String[] arrayInput = new String[quality];
        for (int i = 0; i < arrayInput.length; i++) {
            System.out.print((i + 1) + "'s input : ");
            if (scanner.hasNext()) {
                do {
                    input = checkRegex(scanner, regex, warning);
                    unique = checkUnique(input, arrayInput);
                    if (!unique) {
                        System.out.print((i + 1) + "'s input no unique. Please try again : ");
                    }
                } while (!unique);
                arrayInput[i] = input;
            }
        }
        return arrayInput;
    }

    private static String getString(Scanner scanner, String regex) {
        String input;
        do {
            while (!scanner.hasNext(regex)) {
                System.out.println(Message.INVALID_INPUT);
                scanner.nextLine();
            }
            input = scanner.nextLine();
        } while (input.isEmpty());
        return input;
    }

    private static String getPhoneRegex(Scanner scanner, String regex, String warning) {
        String input;
        boolean matches;
        do {
            input = scanner.nextLine();
            matches = input.matches(regex);
            if (!matches) {
                System.out.println(warning);
            }
        } while (!matches);
        return input;
    }

    private static int getNumber(Scanner scanner, String regex) {
        int input;
        do {
            System.out.println("Please enter a number 1-3:");
            while (!scanner.hasNext(regex)) {
                System.out.println(Message.INVALID_INPUT);
                scanner.next();
            }
            input = scanner.nextInt();
        } while (input < 1 || input > 3);
        scanner.nextLine();
        return input;
    }

    private static boolean checkUnique(String s, String[] array) {
        if (s != null && array != null) {
            if (Arrays.stream(array).filter(a -> s.equals(a)).count() < 1) {
                return true;
            }
        }
        return false;
    }
}