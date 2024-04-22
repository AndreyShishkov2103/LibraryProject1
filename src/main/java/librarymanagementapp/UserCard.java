package librarymanagementapp;
/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author Larysa Petrova
 * @version 21-Apr-24
 **/

import librarymanagementapp.entity.Book;
import librarymanagementapp.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserCard {
    private User user;
    private List<Book> userBookList;
    private int booksLimit;
    private boolean isClosed;

    public UserCard(User user) {
        this.user = user;
        this.userBookList = new ArrayList<>();
        this.isClosed = false;
    }

    public boolean borrowBook(Book book) {
        if (userBookList.size() < booksLimit) {
            userBookList.add(book);
            return true;
        } else {
            System.out.println("You have reached the limit of borrowed books.");
            return false;
        }
    }

    public boolean returnBook(Book book) {
        if (userBookList.contains(book)) {
            userBookList.remove(book);
            return true;
        } else {
            System.out.println("The book is not borrowed by this user.");
            return false;
        }
    }

    public void closeCard() {
        userBookList.clear();
        this.isClosed = true;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getUserBookList() {
        return userBookList;
    }

    public void setUserBookList(List<Book> userBookList) {
        this.userBookList = userBookList;
    }

    public int getBooksLimit() {
        return booksLimit;
    }

    public void setBooksLimit(int booksLimit) {
        this.booksLimit = booksLimit;
    }

    public void reopenCard() {
        this.userBookList = new ArrayList<>();
        this.isClosed = false;
    }

    public void put(Integer userId, librarymanagementapp.UserCard userCard) {
    }

    public void setClosed(boolean b) {
    }

    public Integer getUserId() {
        return this.user.getUserId();
    }
}
