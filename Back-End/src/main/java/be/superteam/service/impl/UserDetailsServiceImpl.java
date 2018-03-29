package be.superteam.service.impl;

import be.superteam.dao.UserDao;
import be.superteam.model.entity.User;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Primary
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User found = userDao.findByUsername(username);

        if (found == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        return found;
    }
}
