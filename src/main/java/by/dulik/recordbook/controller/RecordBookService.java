package by.dulik.recordbook.controller;

import by.dulik.recordbook.entity.RecordBook;
import static by.dulik.recordbook.entity.RecordBook.createRecordBook;
import by.dulik.recordbook.entity.User;
import by.dulik.recordbook.util.InputScannerUtil;
import by.dulik.recordbook.util.Message;
import java.util.Scanner;
import java.util.Set;

public class RecordBookService {

    private static RecordBookService instance;

    public static synchronized RecordBookService getInstance() {
        if (instance == null) {
            instance = new RecordBookService();
        }
        return instance;
    }

    private RecordBookService() {
    }

    private RecordBook first = createRecordBook();
    private UserService userService = new UserService();
    private InputScannerUtil inputUtil = InputScannerUtil.getInstance();
    private IOService ioService = IOService.getInstance();
    private boolean quit = false;

    private void addUserToBook(Scanner scanner) {
        int preSize = first.getSizeSet();
        User newUser = userService.createUser(scanner);
        first.addUser(newUser);
        int postSize = first.getSizeSet();
        String inputConsole = (preSize == postSize) ? (newUser.fullName() + "User isn't unique.")
                : (newUser.fullName() + " - was created.");
        System.out.println(inputConsole);
    }

    private void editUserToBook(Scanner scanner) {
        String[] inputFullName = inputUtil.inputFullName(scanner);
        User user = first.findUserByFullName(inputFullName);
        if (user == null) {
            System.out.println(Message.USER_NOT_FOUND);
        } else {
            User editUser = userService.editUser(inputFullName, scanner);
            String inputConsole = first.editUser(editUser) ? (editUser.fullName() + " changed")
                    : Message.USER_NOT_FOUND;
            System.out.print(inputConsole + "\r");
        }
    }

    private void findUserToFullName(Scanner scanner) {
        User user = first.findUserByFullName(inputUtil.inputFullName(scanner));
        if (user == null) {
            System.out.println(Message.USER_NOT_FOUND);
        } else {
            System.out.println(user);
        }
    }

    private void findAllUser() {
        Set<User> allUsers = first.findAll();
        if (allUsers.isEmpty()) {
            System.out.println("RecordBook is empty.");
        } else {
            System.out.println(Message.ALL_USERS);
            allUsers.forEach(System.out::println);
            System.out.println(Message.OUT_LINE);
        }
    }

    private void deleteUser(Scanner scanner) {
        User user = first.findUserByFullName(inputUtil.inputFullName(scanner));
        if (user == null) {
            System.out.println(Message.USER_NOT_FOUND);
        } else {
            first.deleteUser(user);
            System.out.println(user.fullName() + " - was deleted.");
        }
    }

    private void saveUserTextFile(Scanner scanner) {
        User user = first.findUserByFullName(inputUtil.inputFullName(scanner));
        if (user == null) {
            System.out.println(Message.USER_NOT_FOUND);
        } else {
            ioService.writeUserText(user);
            System.out.println("Create " + user.getFirstName() + user.getLastName() + ".txt file.");
        }
    }

    private void openBookCase() {
        System.out.println("Opening...");
        Set<User> openSet = ioService.readSetToFile();
        first.openSaveSet(openSet);
        System.out.println("Done.");
    }

    private void saveBookCase() {
        Set<User> allUsers = first.findAll();
        if (allUsers != null) {
            ioService.writeSetToFile(allUsers);
            System.out.println("RecordBook saved.");
        }
    }

    public void run(Scanner scanner) {
        printActions();
        while (!quit) {
            System.out.println("Enter action: (9 to show available actions)");
            int action;
            do {
                while (!scanner.hasNextInt()) {
                    System.out.println(Message.INVALID_INPUT);
                    scanner.nextLine();
                }
                action = scanner.nextInt();
            } while (action < 0);
            switch (action) {
                case 0:
                    System.out.println("Shutting down.");
                    quit = true;
                    break;
                case 1:
                    addUserToBook(scanner);
                    break;
                case 2:
                    editUserToBook(scanner);
                    break;
                case 3:
                    findUserToFullName(scanner);
                    break;
                case 4:
                    findAllUser();
                    break;
                case 5:
                    deleteUser(scanner);
                    break;
                case 6:
                    saveUserTextFile(scanner);
                    break;
                case 7:
                    openBookCase();
                    break;
                case 8:
                    saveBookCase();
                    break;
                case 9:
                    printActions();
                    break;
            }
        }
    }

    public void printActions() {
        System.out.println("RecordBook actions:");
        System.out.println("0 - shutting down\n"
                + "1 - add user\n"
                + "2 - edit user\n"
                + "3 - find user\n"
                + "4 - find all users\n"
                + "5 - delete user\n"
                + "6 - save user to text file\n"
                + "7 - open RecordBook\n"
                + "8 - save RecordBook\n"
                + "9 - print a list of available actions\n");
        System.out.println("Choose your action:");
    }
}