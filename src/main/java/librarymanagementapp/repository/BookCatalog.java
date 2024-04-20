package librarymanagementapp.repository;

import librarymanagementapp.UserCard;
import librarymanagementapp.entity.Book;

import java.util.HashMap;
import java.util.Map;

public class BookCatalog {
    private Map<Integer, Book> books;
    private Map<Integer, UserCard> userCards;

    public BookCatalog() {
        this.books = new HashMap<>();
        this.userCards = new HashMap<>();
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public Map<Integer, UserCard> getUserCards() {
        return userCards;
    }

    public void addBook(Book book) {
        books.put(book.getCatalogNumber(), book);
    }

    public static void main(String[] args) {
        BookCatalog catalog = new BookCatalog();

        catalog.addBook(new Book("Taras Shevchenko", "Kobzar", "Poetry", "Kyiv Old Guard", 1));
        catalog.addBook(new Book("Ivan Franko", "Za dvoma zaitsiamy", "Drama", "Lviv Printing House", 2));
        catalog.addBook(new Book("Lesia Ukrainka", "Lisova pisnia", "Poetry", "Kyiv Old Guard", 3));
        catalog.addBook(new Book("Ivan Nechuy-Levytsky", "Pіznorid", "Novel", "Kyiv Old Guard", 4));
        catalog.addBook(new Book("Mykhailo Kotsiubynsky", "Intermezzo", "Novel", "Kyiv Old Guard", 5));
        catalog.addBook(new Book("Panas Myrny", "Pіsnі smutku", "Novel", "Lviv Printing House", 6));
        catalog.addBook(new Book("Marko Vovchok", "Novellas", "Novel", "Lviv Printing House", 7));
        catalog.addBook(new Book("Ivan Franko", "Pіsnі smіlі", "Poetry", "Kyiv Old Guard", 8));
        catalog.addBook(new Book("Lesia Ukrainka", "Kaminnyi hospodar", "Drama", "Lviv Printing House", 9));
        catalog.addBook(new Book("Pavlo Tychyna", "Pluh", "Poetry", "Kyiv Old Guard", 10));
    }
}