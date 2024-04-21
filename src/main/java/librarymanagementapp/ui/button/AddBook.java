package librarymanagementapp.ui.button;

import librarymanagementapp.repository.BookCatalogRepository;
import librarymanagementapp.service.BookCatalogService;
import librarymanagementapp.service.util.UserInput;

public class AddBook implements MenuCommand {

    private final BookCatalogService bookCatalogService;

    public AddBook(BookCatalogService bookCatalogService) {
        this.bookCatalogService = bookCatalogService;
    }

    @Override
    public void executeCommand() {
        String author = UserInput.getText("Author: ");
        String bookTitle = UserInput.getText("Titel: ");
        String genre = UserInput.getText("Genre: ");
        String publisher = UserInput.getText("Publisher: ");
        int id = bookCatalogService.addBook(author, bookTitle, genre, publisher);
        System.out.println("Book added under catalog number: " + id);
    }

    @Override
    public String getMenuName() {
        return "Add new book";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
