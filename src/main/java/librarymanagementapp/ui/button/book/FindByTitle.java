package ui.button.book;

import java.util.List;

import librarymanagementapp.entity.Book;
import librarymanagementapp.service.BookCatalogService;
import librarymanagementapp.service.util.UserInput;
import librarymanagementapp.ui.button.MenuCommand;

public class FindByTitle implements MenuCommand {

    private final BookCatalogService bookCatalogService;

    public FindByTitle(BookCatalogService bookCatalogService) {
        this.bookCatalogService = bookCatalogService;
    }

    @Override
    public void executeCommand() {
        String title = UserInput.getText("Enter book title: ");
        List<Book> books = bookCatalogService.findByTitle(title);
        if (books.size() > 0) {
            for (Book book : books) {
                System.out.println(book);
            }
        } else{
            System.out.println("No book with this title found");
        }
    }

    @Override
    public String getMenuName() {
        return "Find by Title";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
