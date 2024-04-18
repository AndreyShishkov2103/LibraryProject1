package librarymanagementapp;

import java.util.Scanner;

public class LibraryApp {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        byte menuItem;

        System.out.println("=====================");
        System.out.println("**** App menu: ****");
        System.out.println("=====================");
        System.out.println("[1] Add new book");
        System.out.println("[2] View book catalog");
        System.out.println("[3] Find a book by catalog number");
        System.out.println("[4] Find a book by author");
        System.out.println("[5] Find a book by book title");
        System.out.println("[6] Create a new reader card");
        System.out.println("[7] View reader card");
        System.out.println("[8] Close reader card");
        System.out.println("[9] Reopen reader card");
        System.out.println("[10] Borrow a book from the library");
        System.out.println("[11] Return the book to the library");
        System.out.println("[12] Remove book from catalog");
        System.out.println("[13] Exit App");
        System.out.println("=====================");

        System.out.print("Please select menu item: ");



        do {
            menuItem = scanner.nextByte();

            switch (menuItem) {
                case 1:
                    System.out.println("Please add new book to library catalog:");
                    break;
                case 2:
                    System.out.println("Book catalog");
                    break;
                case 3:
                    System.out.println("Please enter catalog number to find a book");
                    break;
                case 4:
                    System.out.println("Please write the author's name to find all his books");
                    break;
                case 5:
                    System.out.println("Please enter book title to find a book");
                    break;
                case 6:
                    System.out.println("Please enter reader information to create reader card");
                    break;
                case 7:
                    System.out.println("Please enter reader to view a reader card");
                    break;
                case 8:
                    System.out.println("Close reader card");
                    break;
                case 9:
                    System.out.println("Reactivate reader card");
                    break;
                case 10:
                    System.out.println("Borrow a book. Enter reader");
                    break;
                case 11:
                    System.out.println("Return the book. Enter reader");
                    break;
                case 12:
                    System.out.println("Please enter book catalog number");
                    break;
                case 13:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid menu item, please try again!");
            }
        } while (menuItem != 13);
    }
}
