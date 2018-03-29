package be.superteam.dao;

import be.superteam.model.entity.Authority;
import be.superteam.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User save(User user);

    User findByUsername(String username);
}
