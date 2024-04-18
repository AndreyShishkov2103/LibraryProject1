package librarymanagementapp.service;

import librarymanagementapp.entity.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookCatalogService {
    private Map<Integer, Book> books;

    public BookCatalogService() {
        this.books = new HashMap<>(books);
    }

    public void addBook(Book book) {
        books.put(book.getCatalogNumber(), book);
    }

    public boolean removeBook(int catalogNumber) {
        return books.remove(catalogNumber) != null;
    }

    public Map<Integer, Book> findBookByAuthor(String searchQuery, String type) {
        Map<Integer, Book> result = new HashMap<>();

        // Search by exact match of the author's name
        if (type.equals("exact")) {
            for (Book book : books.values()) {
                if (book.getAuthor().equals(searchQuery)) {
                    result.put(book.getCatalogNumber(), book);
                }
            }
        }
        // Search by partial match of the author's name
        else if (type.equals("partial")) {
            for (Book book : books.values()) {
                if (book.getAuthor().contains(searchQuery)) {
                    result.put(book.getCatalogNumber(), book);
                }
            }
        } else {
            System.out.println("Invalid search type. Valid values are 'exact' or 'partial'.");
        }

        return result;
    }

    public Book findByCatalogNumber(int catalogNumber) {
        Book foundBook = books.get(catalogNumber);
        if (foundBook == null) {
            System.out.println("Book with  this catalog number " + catalogNumber + " not found.");
        }
        return foundBook;
    }
    public List<Book> findByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getBookTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No books found with this title: " + title);
        }
        return result;
    }

    public void printCatalog () {
        books.values().forEach(System.out::println);
    }
}
