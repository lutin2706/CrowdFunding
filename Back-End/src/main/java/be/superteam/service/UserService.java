package be.superteam.service;

import be.superteam.model.entity.User;

public interface UserService {

    User register(String username, String password, boolean isAdmin);

    User findByUsername(String username);
}
