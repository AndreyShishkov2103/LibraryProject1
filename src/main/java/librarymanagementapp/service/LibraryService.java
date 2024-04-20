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

    //TODO
//    User user1 = new User("Alice");
//    User user2 = new User("Bob");
//
//    Book borrowedBook = library.borrowBook("Java Programming");
//        if (borrowedBook != null) {
//        user1.borrowBook(borrowedBook);
//        System.out.println(user1.getName() + " borrowed: " + borrowedBook.getTitle());
//    } else {
//        System.out.println("Book not available.");
//    }
//
//    borrowedBook = library.borrowBook("Java Programming"); // Try to borrow the same book again
//        if (borrowedBook != null) {
//        user2.borrowBook(borrowedBook);
//        System.out.println(user2.getName() + " borrowed: " + borrowedBook.getTitle());
//    } else {
//        System.out.println("Book not available.");
//    }
//
//        library.returnBook(borrowedBook);
//        System.out.println(user2.getName() + " returned: " + borrowedBook.getTitle());
//}

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
