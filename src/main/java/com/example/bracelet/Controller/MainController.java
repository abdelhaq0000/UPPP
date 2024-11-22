package com.example.bracelet.Controller;

import com.example.bracelet.Response.LoginMessage;
import com.example.bracelet.service.UserService;
import com.example.bracelet.dto.logindto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class MainController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/login")
    @ResponseBody
    public ResponseEntity<LoginMessage> loginUser(@RequestBody logindto loginDTO) {
        LoginMessage loginMessage = userService.loadUserByIdbracelet(loginDTO); // Appel à la méthode du service
        return ResponseEntity.ok(loginMessage);
    }
}
