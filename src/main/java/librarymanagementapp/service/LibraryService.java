package librarymanagementapp.service;

import librarymanagementapp.entity.Book;

import java.util.HashMap;
import java.util.Map;

public class LibraryService {
    private Map<Integer, Book> books;

    public LibraryService() {
        books = new HashMap<>();
    }

    public boolean borrowBookFromLibrary(Integer catalogNumber) {
        if (books.containsKey(catalogNumber)) {
            Book book = books.get(catalogNumber);
            if (!book.isInLibrary()) {
                System.out.println("This book is already borrowed.");
                return false;
            } else {
                book.setInLibrary(false);
                System.out.println("Book '" + book.getBookTitle() + "' by " + book.getAuthor() + " has been borrowed.");
                return true;
            }
        } else {
            System.out.println("Book with catalog number " + catalogNumber + " is not available in the library.");
            return false;
        }
    }

    public void returnBookToLibrary(Integer catalogNumber) {
        if (books.containsKey(catalogNumber)) {
            Book book = books.get(catalogNumber);
            book.setInLibrary(true);
            System.out.println("Book '" + book.getBookTitle() + "' by " + book.getAuthor() + " has been returned.");
        } else {
            System.out.println("Book with catalog number " + catalogNumber + " is not available in the library.");
        }
    }

}
