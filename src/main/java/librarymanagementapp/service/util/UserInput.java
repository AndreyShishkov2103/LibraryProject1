package librarymanagementapp.service.util;

import java.util.Scanner;

/**
 * UserInput
 */
public class UserInput {

    private static Scanner scanner = new Scanner(System.in);

    public static String getText(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static Integer getInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
}
