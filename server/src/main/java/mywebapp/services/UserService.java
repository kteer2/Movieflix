package mywebapp.services;

import mywebapp.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
