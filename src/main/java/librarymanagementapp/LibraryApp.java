package librarymanagementapp;

/**
 * @author: Anton Gorbovyi
 * @version: 21.04.2024
 *
 */

import java.util.List;
import java.util.Map;

import librarymanagementapp.repository.UserCardRepository;
import librarymanagementapp.service.UserCardService;
import librarymanagementapp.entity.Book;
import librarymanagementapp.entity.User;
import librarymanagementapp.repository.BookCatalogRepository;
import librarymanagementapp.service.BookCatalogService;
import librarymanagementapp.service.LibraryService;
import librarymanagementapp.UserCard;
import librarymanagementapp.ui.AdminMenu;

public class LibraryApp {

    public static void main(String[] args) {
        BookCatalogRepository bookCatalog = new BookCatalogRepository();
        bookCatalog.init();
        UserCardRepository userCardRepository = new UserCardRepository();

        BookCatalogService bookCatalogService = new BookCatalogService(bookCatalog);
        LibraryService libraryService = new LibraryService(bookCatalog);
        UserCardService userCardService = new UserCardService(userCardRepository);

        Integer currentReader = -1;

        AdminMenu adminMenu = new AdminMenu(bookCatalogService);

        while (true){
            adminMenu.init();
        }

    }

}
