package com.example.bracelet.Controller;

import com.example.bracelet.service.UserService;
import com.example.bracelet.dto.UserRegistrationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> registerUserAccount(@RequestBody UserRegistrationDto registrationDto) {
        try {
            userService.save(registrationDto);
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to register user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
