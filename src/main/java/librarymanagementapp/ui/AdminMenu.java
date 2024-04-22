package librarymanagementapp.ui;

import librarymanagementapp.service.BookCatalogService;
import librarymanagementapp.service.util.UserInput;
import ui.button.book.AddBook;
import librarymanagementapp.ui.BookMenu;
import librarymanagementapp.ui.button.MenuCommand;
import librarymanagementapp.ui.button.ExitMenu;
import ui.button.book.ViewAllBooks;
import ui.button.book.FindBook;
import ui.button.book.RemoveBook;
import librarymanagementapp.ui.button.Back;
import librarymanagementapp.service.UserCardService;
import librarymanagementapp.service.LibraryService;


import java.util.ArrayList;
import java.util.List;

public class AdminMenu {

    ExitMenu exitMenu;
    private List<MenuCommand> menuCommands;
    private BookCatalogService bookCatalogService;
//    private UserCardService userCardService;
//    private LibraryService libraryService;



    public AdminMenu(BookCatalogService bookCatalogService) {
        this.exitMenu = new ExitMenu();
        this.bookCatalogService = bookCatalogService;
        this.menuCommands = new ArrayList<>();
    }

    public void init () {

        System.out.println("=====================");
        System.out.println("**** App menu: ****");
        System.out.println("=====================");
        System.out.println("[1] Book menu");
        System.out.println("[2] Reader menu");
        System.out.println("[3] Library menu");
        System.out.println("[4] " + this.exitMenu.getMenuName());
        System.out.println("=====================");

        int menuItem = UserInput.getInt("Please select menu item: ");

        switch (menuItem) {
            case 1:
                AddBook addBook = new AddBook(bookCatalogService);
                ViewAllBooks viewAllBooks = new ViewAllBooks(bookCatalogService);
                FindBook findBook = new FindBook(bookCatalogService);
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

                menuCommands.clear();


                menuCommands.add(back);
                menuCommands.add(exitMenu);
//                UserCardMenu userCardMenu = new UserCardMenu(menuCommands);
//                userCardMenu.startUserCardMenu();
                break;
            case 3:

                menuCommands.clear();

                menuCommands.add(back);
                menuCommands.add(exitMenu);
//                LibraryMenu libraryMenu = new LibraryMenu(menuCommands);
//                libraryMenu.startLibraryMenu();
                break;
            case 4:
                this.exitMenu.executeCommand();
                break;
            default:
                System.out.println("Invalid menu item, please try again!");
        }
    }

}
