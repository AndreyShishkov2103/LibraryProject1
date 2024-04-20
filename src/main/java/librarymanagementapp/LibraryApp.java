package librarymanagementapp;

/**
 * @author: Anton Gorbovyi
 * @version: 19.04.2024
 *
 */

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import librarymanagementapp.UserCardService;
import librarymanagementapp.entity.Book;
import librarymanagementapp.entity.User;
import librarymanagementapp.repository.BookCatalog;
import librarymanagementapp.service.BookCatalogService;
import librarymanagementapp.service.LibraryService;
import librarymanagementapp.service.util.UserInput;
import librarymanagementapp.UserCard;

public class LibraryApp {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BookCatalog bookCatalog = new BookCatalog();
        BookCatalogService bookCatalogService = new BookCatalogService(bookCatalog.getBooks());
        LibraryService libraryService = new LibraryService(bookCatalog.getBooks());
        UserCardService userCardService = new UserCardService(bookCatalog.getUserCards());

        Integer currentReader = -1;

        byte menuItem;

        do {
            System.out.println("=====================");
            System.out.println("**** App menu: ****");
            System.out.println("=====================");
            System.out.println("[1] Add new book");
            System.out.println("[2] View book catalog");
            System.out.println("[3] Find a book by catalog number");
            System.out.println("[4] Find a book by author");
            System.out.println("[5] Find a book by book title");
            System.out.println("[6] Create a new reader card");
            System.out.println("[7] View reader card");
            System.out.println("[8] Close reader card");
            System.out.println("[9] Reopen reader card");
            System.out.println("[10] Borrow a book from the library");
            System.out.println("[11] Return the book to the library");
            System.out.println("[12] Remove book from catalog");
            System.out.println("[13] Exit App");
            System.out.println("=====================");

            System.out.print("Please select menu item: ");

            menuItem = scanner.nextByte();

            switch (menuItem) {
                case 1:
                    System.out.println("**** Add new book ****");
                    System.out.println("Please enter book information:");
                    String author = UserInput.getText("Author: ");
                    String bookTitle = UserInput.getText("Titel: ");
                    String genre = UserInput.getText("Genre: ");
                    String publisher = UserInput.getText("Publisher: ");
                    Integer catalogNumber = bookCatalog.getBooks().size();
                    System.out.println("Book catalog number: " + catalogNumber);
                    Book book = new Book(author, bookTitle, genre, publisher, catalogNumber);
                    bookCatalogService.addBook(book);
                    System.out.println("New book added" + book);

                    System.out.println("============================");
                    System.out.print("Please select menu item: ");
                    break;
                case 2:
                    System.out.println("**** View book catalog ****");
                    bookCatalogService.printCatalog();

                    System.out.println("============================");
                    System.out.print("Please select menu item: ");
                    break;
                case 3:
                    System.out.println("**** Find a book by catalog number ****");
                    int id = UserInput.getInt("Please enter catalog number to find a book: ");
                    Book book1 = bookCatalogService.findByCatalogNumber(id);
                    System.out.println(book1);

                    System.out.println("============================");
                    System.out.print("Please select menu item: ");
                    break;
                case 4:
                    System.out.println("**** Find a book by author ****");
                    System.out.println("Please write the author's name to find all his books");
                    String findByAuthor = UserInput.getText("Author: ");
                    Map<Integer, Book> bookAuthor = bookCatalogService.findBookByAuthor(findByAuthor, "exact");
                    if (bookAuthor.size() == 0) {
                        System.out.println("Book is not found");
                    } else {
                        for (Book book2 : bookAuthor.values())
                            System.out.println(book2);
                    }

                    System.out.println("============================");
                    System.out.print("Please select menu item: ");
                    break;
                case 5:
                    System.out.println("**** Find a book by book title ****");
                    System.out.println("Please enter book title to find a book");
                    String findByTitle = UserInput.getText("Book title: ");
                    List<Book> title = bookCatalogService.findByTitle(findByTitle);
                    if (findByTitle.length() == 0) {
                        System.out.println("Book is not found");
                    } else {
                        for (Book book2 : title)
                            System.out.println(book2);
                    }

                    System.out.println("============================");
                    System.out.print("Please select menu item: ");
                    break;
                case 6:
                    System.out.println("**** Create a new reader card ****");
                    System.out.println("Please enter reader information to create reader card");
                    String name = UserInput.getText("Reader name: ");
                    String surname = UserInput.getText("Reader surname: ");
                    currentReader = bookCatalog.getUserCards().size();
                    int limit = 5;
                    System.out.println("Reader Card ID: " + currentReader);
                    User user = new User(currentReader, name, surname);
                    userCardService.addNewUserCard(user, limit);

                    System.out.println("============================");
                    System.out.print("Please select menu item: ");
                    break;
                case 7:
                    System.out.println("**** View reader card ****");
                    System.out.println("Please enter reader to view a reader card");

                    // find user card by name
//                    String userName = UserInput.getText("Enter reader name:");
//                    userCardService.findUserCardByName(userName);

                    currentReader = UserInput.getInt("Enter reader id:");
                    userCardService.findUserCardById(currentReader);
                    int userId2 = UserInput.getInt("Enter reader id: ");
                    userCardService.findUserCardById(userId2);

                    System.out.println("============================");
                    System.out.print("Please select menu item: ");
                    break;
                case 8:
                    System.out.println("Close reader card");
                    currentReader = UserInput.getInt("Enter reader id: ");
                    boolean closed = userCardService.closeUserCard(currentReader);
                    System.out.println("**** Close reader card ****");
                    int userId3 = UserInput.getInt("Enter reader id: ");
                    boolean closed = userCardService.closeUserCard(userId3);
                    if (closed) {
                        System.out.println("Reader card was closed!");
                    } else {
                        System.out.println("Reader card still open!");
                    }
                    currentReader = -1;
                    break;
                case 9:
                    System.out.println("Reactivate reader card");
                    currentReader = UserInput.getInt("Enter reader id: ");
                    userCardService.reopenUserCard(currentReader);
                    break;
                case 10:
                    if ( currentReader < 0 )
                    {
                        System.out.println("Please select a reader first!");
                        break;
                    }

                    System.out.println("============================");
                    System.out.print("Please select menu item: ");
                    break;
                case 9:
                    System.out.println("**** Reopen reader card ****");
                    int userId4 = UserInput.getInt("Enter reader id: ");
                    userCardService.reopenUserCard(userId4);

                    System.out.println("============================");
                    System.out.print("Please select menu item: ");
                    break;
                case 10:
                    System.out.println("**** Borrow a book from the library ****");
                    int bookCatalogNumberBorrow = UserInput.getInt("Enter book catalog number: ");
                    boolean borrowed = libraryService.borrowBookFromLibrary(bookCatalogNumberBorrow, currentReader);
                    if (borrowed) {
                        System.out.println("Book was borrowed");
                    } else {
                        System.out.println("Book was not borrowed");
                    }

                    System.out.println("============================");
                    System.out.print("Please select menu item: ");
                    break;
                case 11:
                    if ( currentReader < 0 )
                    {
                        System.out.println("Please select a reader first!");
                        break;
                    }
                    System.out.println("Return the book. Enter reader");
                    System.out.println("**** Return the book to the library ****");
                    int bookCatalogNumberReturn = UserInput.getInt("Enter book catalog number: ");
                    libraryService.returnBookToLibrary(bookCatalogNumberReturn);

                    System.out.println("============================");
                    System.out.print("Please select menu item: ");
                    break;
                case 12:
                    System.out.println("**** Remove book from catalog ****");
                    int bookCatalogNumberRemove = UserInput.getInt("Enter book catalog number: ");
                    boolean remove = bookCatalogService.removeBook(bookCatalogNumberRemove);
                    if (remove) {
                        System.out.println("Book was removed from catalog");
                    } else {
                        System.out.println("Book was not removed");
                    }

                    System.out.println("============================");
                    System.out.print("Please select menu item: ");
                    break;
                case 13:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid menu item, please try again!");
            }
        } while (menuItem != 13);
    }

}
