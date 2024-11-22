package com.example.bracelet.Controller;


import com.example.bracelet.model.User;
import com.example.bracelet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class userController {

    @Autowired
    private UserService userService;

    // Endpoint to get user by idbracelet
    @GetMapping("/{idbracelet}")
    public User getUserByIdbracelet(@PathVariable String idbracelet) {
        return userService.getUserByIdbracelet(idbracelet);
    }

}
