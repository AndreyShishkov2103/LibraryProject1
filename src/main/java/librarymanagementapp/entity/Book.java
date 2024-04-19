package librarymanagementapp.entity;

public class Book {

    private String author;
    private String bookTitle;
    private String genre;
    private String publisher;
    private Integer catalogNumber;
    private boolean isInLibrary;

    public Book(String author, String bookTitle, String genre, String publisher, Integer catalogNumber, boolean isInLibrary) {
        this.author = author;
        this.bookTitle = bookTitle;
        this.genre = genre;
        this.publisher = publisher;
        this.catalogNumber = catalogNumber;
        this.isInLibrary = isInLibrary;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public Integer getCatalogNumber() {
        return catalogNumber;
    }
    
    public boolean isInLibrary() {
        return isInLibrary;
    }

    public void setInLibrary(boolean inLibrary) {
        isInLibrary = inLibrary;
    }

    @Override
    public String toString() {
        return "librarymanagementapp.Book.Book{" +
                "author='" + author + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                ", catalogNumber=" + catalogNumber +
                ", isInLibrary=" + isInLibrary +
                '}';
    }
}
