package librarymanagementapp.ui.button.library;

import librarymanagementapp.service.LibraryService;
import librarymanagementapp.service.util.UserInput;
import librarymanagementapp.ui.button.MenuCommand;

public class BorrowBook implements MenuCommand {
    private final LibraryService libraryService;

    public BorrowBook(LibraryService service) {
        this.libraryService = service;
    }

    @Override
    public void executeCommand() {
        int bookId = UserInput.getInt("Book ID that need to borrow to Reader: ");
        int userId = UserInput.getInt("Reader ID that wish this book to be borrowed: ");
        libraryService.borrowBookFromLibrary(bookId, userId);
    }

    @Override
    public String getMenuName() {
        return "Borrow Book";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
