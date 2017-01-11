package be.kdg.shop.persistence.dao.interfaces;

import be.kdg.shop.model.user.User;

import java.util.Map;

public interface UserDAO
{
    User getUser(String username);

    void addUser(User user);

    void removeUser(String username);

    Map<String, User> getUsers();
}
