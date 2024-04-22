package librarymanagementapp.service;

import librarymanagementapp.entity.Book;
import librarymanagementapp.repository.BookCatalogRepository;


public class LibraryService {
    private BookCatalogRepository repository;

    public LibraryService(BookCatalogRepository repository) {
        this.repository = repository;
    }


    public boolean borrowBookFromLibrary(Integer catalogNumber, int userCardNo) {
        Book book = repository.get(catalogNumber);
        if (book != null) {
            if (!book.isInLibrary()) {
                if (book.getBorrowedTo() == userCardNo)
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
        Book book = repository.get(catalogNumber);
        if (book != null) {
            book.setInLibrary();
            System.out.println("Book '" + book.getBookTitle() + "' by " + book.getAuthor() + " has been returned.");
        } else {
            System.out.println("Book with catalog number " + catalogNumber + " is not available in the library.");
        }
    }

}

