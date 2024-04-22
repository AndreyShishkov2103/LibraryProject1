package librarymanagementapp.ui.button.book;

import librarymanagementapp.service.BookCatalogService;
import librarymanagementapp.ui.FindBookMenu;
import librarymanagementapp.ui.button.ExitMenu;
import librarymanagementapp.ui.button.MenuCommand;

import java.util.ArrayList;
import java.util.List;

public class FindBook implements MenuCommand {

    private final BookCatalogService bookCatalogService;
    private List<MenuCommand> menuCommands;


    public FindBook(BookCatalogService bookCatalogService) {
        this.bookCatalogService = bookCatalogService;
        menuCommands = new ArrayList<MenuCommand>();
    }

    @Override
    public void executeCommand() {
        FindByAuthor author = new FindByAuthor(bookCatalogService);
        FindByTitle title = new FindByTitle(bookCatalogService);
        FindById id = new FindById(bookCatalogService);
        ExitMenu exit = new ExitMenu();

        menuCommands.clear();
        menuCommands.add(null);
        menuCommands.add(author);
        menuCommands.add(title);
        menuCommands.add(id);
        menuCommands.add(exit);
        FindBookMenu findMenu = new FindBookMenu(menuCommands);
        findMenu.startUserMenu();
    }

    @Override
    public String getMenuName() {
        return "Find a book";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
