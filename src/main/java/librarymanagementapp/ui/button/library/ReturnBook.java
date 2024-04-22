package librarymanagementapp.ui.button.library;

import librarymanagementapp.service.LibraryService;
import librarymanagementapp.service.util.UserInput;
import librarymanagementapp.ui.button.MenuCommand;

public class ReturnBook implements MenuCommand {
    private final LibraryService libraryService;

    public ReturnBook(LibraryService service) {
        this.libraryService = service;
    }

    @Override
    public void executeCommand() {
        int bookId = UserInput.getInt("Book ID that need to borrow to Reader: ");
        libraryService.returnBookToLibrary(bookId);
    }

    @Override
    public String getMenuName() {
        return "Return Book";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
