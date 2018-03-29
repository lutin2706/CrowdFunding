package be.superteam.service.impl;

import be.superteam.dao.AuthorityDao;
import be.superteam.dao.UserDao;
import be.superteam.model.entity.Authority;
import be.superteam.model.entity.User;
import be.superteam.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final AuthorityDao authorityDao;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, AuthorityDao authorityDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.authorityDao = authorityDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String username, String password, boolean isAdmin) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setAuthorities(new ArrayList<>(Collections.singletonList(createOrGetAuthority("ROLE_USER"))));
        if (isAdmin) {
            user.getAuthorities().add(createOrGetAuthority("ROLE_ADMIN"));
        }
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        return userDao.save(user);
    }

    public Authority createOrGetAuthority(String authority) {

        Authority found = authorityDao.findByAuthority(authority);

        if (found == null) {
            found = new Authority(authority);
            authorityDao.save(found);
        }

        return found;
    }
}
