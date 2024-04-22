package librarymanagementapp.ui.button.user;

import librarymanagementapp.service.UserCardService;
import librarymanagementapp.service.util.UserInput;
import librarymanagementapp.ui.button.MenuCommand;

public class CloseUserCard implements MenuCommand {

    private final UserCardService userCardService;

    public CloseUserCard(UserCardService userCardService) {
        this.userCardService = userCardService;
    }


    @Override
    public void executeCommand() {
        int userID=UserInput.getInt("Get User ID: ");
        boolean ok = userCardService.closeUserCard(userID);
        if (ok) {
            System.out.println("User Card was successfully closed!");
        } else {
            System.out.println("User Card was not closed!");
        }
    }

    @Override
    public String getMenuName() {
        return "Close User Card";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}