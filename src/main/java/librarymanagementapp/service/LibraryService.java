package librarymanagementapp.service;

import librarymanagementapp.entity.Book;
import librarymanagementapp.entity.User;

import java.util.HashMap;
import java.util.Map;

public class LibraryService {
    private Map<Integer, Book> books;

    public LibraryService(Map<Integer, Book> books) {
        this.books = books;
    }

    public boolean borrowBookFromLibrary(Integer catalogNumber, int userCardNo) {
        if (books.containsKey(catalogNumber)) {
            Book book = books.get(catalogNumber);
            if (!book.isInLibrary()) {
                if ( book.getBorrowedTo() == userCardNo )
                    System.out.println("This book is already borrowed to the same reader.");
                else
                    System.out.println("This book is already borrowed to another reader.");
                return false;
            } else {
                book.setNotInLibrary(userCardNo);
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
            book.setInLibrary();
            System.out.println("Book '" + book.getBookTitle() + "' by " + book.getAuthor() + " has been returned.");
        } else {
            System.out.println("Book with catalog number " + catalogNumber + " is not available in the library.");
        }
    }

}
