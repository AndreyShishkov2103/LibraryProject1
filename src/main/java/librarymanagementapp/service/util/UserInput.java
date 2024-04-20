package librarymanagementapp.service.util;

import java.util.Scanner;

/**
 * UserInput
 */
public class UserInput {

    private static Scanner scanner = new Scanner(System.in);

    public static String getText(String message) {
<<<<<<< HEAD

        String val = "";
        System.out.println(message);

        do {
            val = scanner.nextLine();

            if ( val.length() < 2 )
            {
                System.out.println("Error: empty or too short value");
                val = "";
            }

        } while ( val.length() == 0 );

        return val;
    }

    public static Integer getInt(String message) {

        Integer val = -1;
        System.out.println(message);

        do {
            val = scanner.nextInt();

            if ( val < 0 )
            {
                System.out.println("Error: invalid value");
            }

        } while ( val < 0 );

        return val;
=======
        System.out.print(message);
        return scanner.nextLine();
    }

    public static Integer getInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
>>>>>>> f61767c4ffb7d283387ac6e9f728fce0c97483fd
    }
}



