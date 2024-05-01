package librarymanagementapp.ui.button.user;

/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author: Anton Gorbovyi
 * @version: 22.04.2024
 **/

import librarymanagementapp.service.UserCardService;
import librarymanagementapp.service.util.UserInput;
import librarymanagementapp.ui.button.MenuCommand;

public class FindUserCardByName implements MenuCommand {

    private final UserCardService userCardService;

    public FindUserCardByName(UserCardService userCardService) {
        this.userCardService = userCardService;
    }


    @Override
    public void executeCommand() {
        String userName=UserInput.getText("Get User Name: ");
        userCardService.findUserCardByName(userName);
    }

    @Override
    public String getMenuName() {
        return "Find User Card by Name";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
