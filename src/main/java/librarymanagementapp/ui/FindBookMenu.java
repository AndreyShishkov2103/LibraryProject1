package librarymanagementapp.ui;

import librarymanagementapp.ui.button.MenuCommand;
import librarymanagementapp.service.util.UserInput;
import librarymanagementapp.ui.button.ExitMenu;
import java.util.Scanner;
import java.util.List;

public class FindBookMenu {

    ExitMenu exitMenu;

    private final List<MenuCommand> commands;

    public FindBookMenu(List<MenuCommand> commands) {
        this.commands = commands;
    }

    public void startUserMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exitRequested = false;

        while (!exitRequested) {
            for (int i = 1; i < commands.size(); i++) {
                System.out.println("[" + i + "] " + commands.get(i).getMenuName());
            }
            System.out.println("Please make your choice: ");

            int userInput = scanner.nextInt();
            if (userInput < 0 || userInput >= commands.size()) {
                System.out.println("Invalid option, please try again.");
            } else {
                MenuCommand command = commands.get(userInput);
                command.executeCommand();
                exitRequested = command.shouldExit();
            }
        }
    }

}
