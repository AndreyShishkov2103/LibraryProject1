package librarymanagementapp.ui;

import librarymanagementapp.service.util.UserInput;
import librarymanagementapp.ui.button.ExitMenu;

public class FindBookMenu {

    ExitMenu exitMenu;

    public FindBookMenu() {
        this.exitMenu = new ExitMenu();
    }

    public void init () {

        System.out.println("=====================");
        System.out.println("**** App menu: ****");
        System.out.println("=====================");
        System.out.println("[1] Find by author");
        System.out.println("[2] Reader");
        System.out.println("[3] Library");
        System.out.println("[4] " + this.exitMenu.getMenuName());
        System.out.println("=====================");

        int menuItem = UserInput.getInt("Please select menu item: ");

        switch (menuItem) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                this.exitMenu.executeCommand();
                break;
            default:
                System.out.println("Invalid menu item, please try again!");
        }
    }

}
