package be.superteam.controller;

import be.superteam.model.dto.UserFormDTO;
import be.superteam.model.entity.User;
import be.superteam.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.security.Principal;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    private final UserDetailsService userDetailsService;

    public UserController(UserService userService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserFormDTO userFormDTO) {
        User created = userService.register(userFormDTO.username, userFormDTO.password, false);
        return ResponseEntity.created(URI.create("/api/users/" + created.getId())).body(created);
    }

    @GetMapping("/user/whoami")
    public ResponseEntity whoAmI(Principal principal) {
        User user = (User) userDetailsService.loadUserByUsername(principal.getName());
        user.setPassword(null);
        return ResponseEntity.ok(user);
    }
}
