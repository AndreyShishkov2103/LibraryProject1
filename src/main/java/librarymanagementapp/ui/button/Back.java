package librarymanagementapp.ui.button;

import librarymanagementapp.ui.AdminMenu;
import librarymanagementapp.ui.BookMenu;

public class Back implements MenuCommand {
    private AdminMenu adminMenu;
    private BookMenu bookMenu;

    public Back(AdminMenu adminMenu) {
        this.adminMenu = adminMenu;
    }
    public Back(BookMenu bookMenu) {
        this.bookMenu = bookMenu;
    }

    @Override
    public void executeCommand() {
        if (adminMenu == null) {
            bookMenu.startUserMenu();
        } else {
            adminMenu.init();
        }
    }

    @Override
    public String getMenuName() {
        return "Back";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
