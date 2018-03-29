package be.superteam.config;

import be.superteam.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class DbInit implements InitializingBean {

    private final UserService userService;

    public DbInit(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        userService.register("sev", "sev", false);
        userService.register("toto", "toto", false);
        userService.register("admin", "admin", true);
    }
}