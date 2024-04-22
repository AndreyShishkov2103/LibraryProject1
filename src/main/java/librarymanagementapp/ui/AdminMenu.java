package librarymanagementapp.ui;

import librarymanagementapp.service.BookCatalogService;
import librarymanagementapp.service.util.UserInput;
import librarymanagementapp.ui.button.*;

import java.util.ArrayList;
import java.util.List;

public class AdminMenu {

    ExitMenu exitMenu;
    private BookCatalogService bookCatalogService;
    private List<MenuCommand> menuCommands;


    public AdminMenu(BookCatalogService bookCatalogService) {
        this.exitMenu = new ExitMenu();
        this.bookCatalogService = bookCatalogService;
        this.menuCommands = new ArrayList<>();
    }

    public void init () {

        System.out.println("=====================");
        System.out.println("**** App menu: ****");
        System.out.println("=====================");
        System.out.println("[1] Book");
        System.out.println("[2] Reader");
        System.out.println("[3] Library");
        System.out.println("[4] " + this.exitMenu.getMenuName());
        System.out.println("=====================");

        int menuItem = UserInput.getInt("Please select menu item: ");

        switch (menuItem) {
            case 1:
                AddBook addBook = new AddBook(bookCatalogService);
                ViewAllBooks viewAllBooks = new ViewAllBooks(bookCatalogService);
                FindBook findBook = new FindBook();
                RemoveBook removeBook = new RemoveBook(bookCatalogService);
                Back back = new Back(this);
                menuCommands.clear();
                menuCommands.add(null);
                menuCommands.add(addBook);
                menuCommands.add(viewAllBooks);
                menuCommands.add(findBook);
                menuCommands.add(removeBook);
                menuCommands.add(back);
                menuCommands.add(exitMenu);
                BookMenu bookMenu = new BookMenu(menuCommands);
                bookMenu.startUserMenu();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                this.exitMenu.executeCommand();
                break;
            default:
                System.out.println("Invalid menu item, please try again!");
        }
    }

}
