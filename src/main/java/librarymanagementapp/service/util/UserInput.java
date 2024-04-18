package librarymanagementapp.service.util;

import java.util.Scanner;

/**
 * UserInput
 */
public class UserInput {

    private static Scanner scanner = new Scanner(System.in);

    public static String getText(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static Integer getInt(Integer message) {
        System.out.println(message);
        return scanner.nextInt();
    }
}
