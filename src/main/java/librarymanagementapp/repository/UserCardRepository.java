package librarymanagementapp.repository;
/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author Larysa Petrova
 * @version 21-Apr-24
 **/

import librarymanagementapp.UserCard;
import librarymanagementapp.entity.User;

import java.util.*;

public class UserCardRepository implements CrudRepository<Integer, User> {
    private final Map<Integer, UserCard> userCards;

    public UserCardRepository() {
        this.userCards = new HashMap<>();
    }

    @Override
    public void put(Integer key, User value) {
        UserCard newUserCard = new UserCard(value);
        userCards.put(key, newUserCard);
    }

    @Override
    public User get(Integer key) {
        UserCard userCard = userCards.get(key);
        return (userCard != null) ? userCard.getUser() : null;
    }

    @Override
    public void remove(Integer key) {
        userCards.remove(key);
    }

    @Override
    public Collection<User> values() {
        Collection<User> users = new ArrayList<>();
        for (UserCard userCard : userCards.values()) {
            users.add(userCard.getUser());
        }
        return users;
    }

    public void init() {
        List<User> usersList = new ArrayList<>(List.of(
                new User(1, "user", "user"),
                new User(2, "user1", "user1"),
                new User(3, "user2", "user2"),
                new User(4, "user3", "user3"),
                new User(5, "user4", "user4")
        ));
        for (User user : usersList) {
            addUserCards(new UserCard(user));
        }
    }

    public Map<Integer, UserCard> getUserCards() {
        return userCards;
    }

    public void addUserCards(UserCard userCard) {
        userCards.put(userCard.getUserId(), userCard);
    }

    public User getUserById(int userId) {
        return userCards.get(userId).getUser();
    }

    public void updateUserCard(UserCard userCard) {
        if (userCards.containsKey(userCard.getUserId())) {
            userCards.put(userCard.getUserId(), userCard);
        } else {
            System.out.println("User card with ID " + userCard.getUserId() + "does not exist.");
        }
    }

    public void removeUserCard(int userId) {
        if (userCards.containsKey(userId)) {
            userCards.remove(userId);
        } else {
            System.out.println("User card with ID " + userId + "does not exit.");
        }
    }
}
