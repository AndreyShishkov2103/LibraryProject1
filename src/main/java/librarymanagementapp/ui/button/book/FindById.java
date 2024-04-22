package librarymanagementapp.ui.button.book;

import librarymanagementapp.entity.Book;
import librarymanagementapp.service.BookCatalogService;
import librarymanagementapp.service.util.UserInput;
import librarymanagementapp.ui.button.MenuCommand;

public class FindById implements MenuCommand {

    private final BookCatalogService bookCatalogService;

    public FindById(BookCatalogService bookCatalogService) {
        this.bookCatalogService = bookCatalogService;
    }

    @Override
    public void executeCommand() {
        int id = UserInput.getInt("Enter book ID: ");
        Book book = bookCatalogService.findByCatalogNumber(id);
        if (book != null) {
            System.out.println(book);
        } else{
            System.out.println("No book with this ID found");
        }
    }

    @Override
    public String getMenuName() {
        return "Find by ID";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
