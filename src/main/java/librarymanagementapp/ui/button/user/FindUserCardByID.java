package librarymanagementapp.ui.button.user;

import librarymanagementapp.service.UserCardService;
import librarymanagementapp.service.util.UserInput;
import librarymanagementapp.ui.button.MenuCommand;

public class FindUserCardByID implements MenuCommand {

    private final UserCardService userCardService;

    public FindUserCardByID(UserCardService userCardService) {
        this.userCardService = userCardService;
    }


    @Override
    public void executeCommand() {
        int userID=UserInput.getInt("Get User ID: ");
        userCardService.findUserCardById(userID);
    }

    @Override
    public String getMenuName() {
        return "Find User Card by ID";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}