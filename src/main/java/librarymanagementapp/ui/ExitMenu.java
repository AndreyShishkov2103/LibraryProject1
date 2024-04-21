package librarymanagementapp.ui;

public class ExitMenu implements MenuCommand{
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
