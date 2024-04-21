package librarymanagementapp.repository;

import librarymanagementapp.entity.Book;

import java.util.*;

public class BookCatalogRepository implements CrudRepository<Integer, Book> {
    private Map<Integer, Book> bookMap;

    public BookCatalogRepository () {
        bookMap = new HashMap<>();
    }

    @Override
    public void put (Book book) {
        bookMap.put(book.getCatalogNumber(), book);
    }

    @Override
    public Book get(Integer catalogNumber) {
        return bookMap.get(catalogNumber);
    }

    @Override
    public void remove(Integer catalogNumber) {
        bookMap.remove(catalogNumber);
    }

    @Override
    public Collection<Book> values() {
        return bookMap.values();
    }

    public void init() {
        List<Book> books = new ArrayList<>(List.of(
                new Book("Taras Shevchenko", "Kobzar", "Poetry", "Kyiv Old Guard", true),
                new Book("Ivan Franko", "Za dvoma zaitsiamy", "Drama", "Lviv Printing House", true),
                new Book("Lesia Ukrainka", "Lisova pisnia", "Poetry", "Kyiv Old Guard", true),
                new Book("Ivan Nechuy-Levytsky", "Pіznorid", "Novel", "Kyiv Old Guard",  true),
                new Book("Mykhailo Kotsiubynsky", "Intermezzo", "Novel", "Kyiv Old Guard",  true),
                new Book("Panas Myrny", "Pіsnі smutku", "Novel", "Lviv Printing House",  true),
                new Book("Marko Vovchok", "Novellas", "Novel", "Lviv Printing House",  true),
                new Book("Ivan Franko", "Pіsnі smіlі", "Poetry", "Kyiv Old Guard",  true),
                new Book("Lesia Ukrainka", "Kaminnyi hospodar", "Drama", "Lviv Printing House",  true),
                new Book("Pavlo Tychyna", "Pluh", "Poetry", "Kyiv Old Guard",  true)
        ));
        books.forEach(book -> put(book));
    }
}