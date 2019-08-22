package by.dulik.recordbook;

import by.dulik.recordbook.controller.RecordBookService;
import java.util.Scanner;

public class Runner {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        RecordBookService recordBookService = RecordBookService.getInstance();
        recordBookService.run(scanner);
    }
}
