package by.dulik.recordbook.controller;

import by.dulik.recordbook.entity.PhoneNumber;
import by.dulik.recordbook.entity.Role;
import by.dulik.recordbook.entity.User;
import by.dulik.recordbook.util.InputScannerUtil;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService {

    private InputScannerUtil inputScannerUtil = InputScannerUtil.getInstance();

    public User createUser(Scanner scanner) {
        String firstName = inputScannerUtil.inputFirstName(scanner);
        String lastName = inputScannerUtil.inputLastName(scanner);
        String email = inputScannerUtil.inputEmail(scanner);
        ArrayList<Role> roles = inputScannerUtil.inputRoles(scanner);
        ArrayList<PhoneNumber> phones = inputScannerUtil.inputPhones(scanner);
        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .roles(roles)
                .phoneNumbers(phones)
                .build();
    }

    public User editUser(String[] fullName, Scanner scanner) {
        String firstName = fullName[0];
        String lastName = fullName[1];
        String email = inputScannerUtil.inputEmail(scanner);
        ArrayList<Role> roles = inputScannerUtil.inputRoles(scanner);
        ArrayList<PhoneNumber> phones = inputScannerUtil.inputPhones(scanner);
        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .roles(roles)
                .phoneNumbers(phones)
                .build();
    }
}