package librarymanagementapp;
/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author Larysa Petrova
 * @version 17-Apr-24
 */

import librarymanagementapp.entity.User;

import java.util.Map;

public class UserCardService {
    private Map<Integer, UserCard> userCards;

    public UserCardService(Map<Integer, UserCard> userCards) {
        this.userCards = userCards;
    }

    /**
     * @param user
     */
    public void addNewUserCard(User user, int limit) {
        if (!userCards.containsKey(user.getUserId())) {
            UserCard userCard = new UserCard(user.getName(), user.getUserId(), limit);
            userCards.put(user.getUserId(), userCard);
            System.out.println("User card created successfully for user: " + user.getName());
        } else {
            System.out.println("User card already exists for user: " + user.getName());
        }
    }

    public void findUserCardByName(String name){
        if (this.userCards.size() == 0){
            System.out.println("User card is not found!");
        } else for (UserCard card : this.userCards.values()) {
            if (card.getUser().getName().equals(name)){
                System.out.println(card);
                return;
            }
        }
        System.out.println("User card is not found!");
    }
    public void findUserCardById(int id){
        if (this.userCards.size() == 0){
            System.out.println("User card is not found!");
        } else for (UserCard card : this.userCards.values()) {
            if (card.getUser().getUserId() == id){
                System.out.println(card);
                return;
            }
        }
        System.out.println("User card is not found!");
    }

    public boolean closeUserCard(int userId) {
        if (userCards.containsKey(userId)) {
            userCards.remove(userId);
            System.out.println("User card closed successfully for user ID: " + userId);
            return true;
        } else {
            System.out.println("User card not found for user ID: + userId");
            return false;
        }
    }

    public void reopenUserCard(int userId) {
        if (userCards.containsKey(userId)) {
            UserCard userCard = userCards.get(userId);
            userCard.setClosed(false);
            System.out.println("User card reopened successfully for user ID: " + userId);
        } else {
            System.out.println("User card not found for user ID: " + userId);
        }
    }
}
