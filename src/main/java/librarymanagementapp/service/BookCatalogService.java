package librarymanagementapp.service;

import librarymanagementapp.entity.Book;
import librarymanagementapp.repository.BookCatalogRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookCatalogService {
    private BookCatalogRepository repository;

    public BookCatalogService(BookCatalogRepository repository) {
        this.repository = repository;
    }

    public void addBook(String author, String bookTitle, String genre, String publisher, Integer catalogNumber) {
        Book book = new Book(author,  bookTitle,  genre,  publisher, catalogNumber);
        repository.put(book);
    }

    public Book get(Integer catalogNumber ) {
        return repository.get(catalogNumber);
    }

    public boolean removeBook(Integer catalogNumber) {
        Book delBook = repository.get(catalogNumber);
        if (delBook != null) {
            repository.remove(catalogNumber);
            return true;
        }
        return false;
    }

    public List<Book> findBookByAuthor(String searchQuery) {
        List<Book> result = new ArrayList<>();

        for (Book book : repository.values()) {
            if (book.getAuthor().toLowerCase().contains(searchQuery.toLowerCase())) {
                result.add(book);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No books found with this author: " + searchQuery);
        }

        return result;
    }

    public Book findByCatalogNumber(int catalogNumber) {
        Book foundBook = repository.get(catalogNumber);
        if (foundBook == null) {
            System.out.println("Book with this catalog number " + catalogNumber + " not found.");
        }
        return foundBook;
    }
    public List<Book> findByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : repository.values()) {
            if (book.getBookTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No books found with this title: " + title);
        }
        return result;
    }

    public void printCatalog () {
        repository.values().forEach(System.out::println);
    }
}
