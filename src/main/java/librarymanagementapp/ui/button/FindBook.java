package librarymanagementapp.ui.button;

import librarymanagementapp.ui.FindBookMenu;

public class FindBook implements MenuCommand {

    private FindBookMenu findBookMenu;

    public FindBook() {
        this.findBookMenu = new FindBookMenu();
    }

    @Override
    public void executeCommand() {
        findBookMenu.init();
    }

    @Override
    public String getMenuName() {
        return "Find a book";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
