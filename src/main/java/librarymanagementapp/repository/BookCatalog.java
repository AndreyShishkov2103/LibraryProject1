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

}
