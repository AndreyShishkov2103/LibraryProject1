package ui.button.user;

import librarymanagementapp.ui.button.MenuCommand;
import librarymanagementapp.service.UserCardService;

public class AddUserCard implements MenuCommand {

    private final UserCardService userCardService;

    public AddUserCard(UserCardService userCardService) {
        this.userCardService = userCardService;
    }


    @Override
    public void executeCommand() {


    }

    @Override
    public String getMenuName() {
        return null;
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
