package librarymanagementapp.entity;

/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author Larysa Petrova
 * @version 21-Apr-24
 **/

public class User {
    private int userID;
    private String name;
    private String surname;
/*    private boolean cardClosed; */

    public User(int userID, String name, String surname) {
        this.userID = userID;
        this.name = name;
        this.surname = surname;
        this.cardClosed = false;
    }

    public String getName() {
        return name;
    }

    public Integer getUserId() {
        return userID;
    }

    public User getUser() {
        return this;
    }

/*     public void closeCard() {
        if (!cardClosed) {
            cardClosed = true;
            System.out.println("User card is closed.");
        } else {
            System.out.println("The user's card is already closed");
        }
    }

   public void reopenCard() {
        if (cardClosed) {
            cardClosed = false;
            System.out.println("The user card is reopened.");
        } else
            System.out.println("User card is already open");
    } */

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

}
