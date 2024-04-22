package librarymanagementapp;

/**
 * @author: Anton Gorbovyi
 * @version: 21.04.2024
 *
 */

import librarymanagementapp.repository.BookCatalogRepository;
import librarymanagementapp.repository.UserCardRepository;
import librarymanagementapp.service.BookCatalogService;
import librarymanagementapp.service.LibraryService;
import librarymanagementapp.service.UserCardService;
import librarymanagementapp.ui.AdminMenu;

public class LibraryApp {

    public static void main(String[] args) {
        BookCatalogRepository bookCatalog = new BookCatalogRepository();
        bookCatalog.init();
        UserCardRepository userCardRepository = new UserCardRepository();
        userCardRepository.init();

        BookCatalogService bookCatalogService = new BookCatalogService(bookCatalog);
        LibraryService libraryService = new LibraryService(bookCatalog);
        UserCardService userCardService = new UserCardService(userCardRepository);

        AdminMenu adminMenu = new AdminMenu(bookCatalogService, userCardService, libraryService);

        while (true){
            adminMenu.init();
        }

    }

}
