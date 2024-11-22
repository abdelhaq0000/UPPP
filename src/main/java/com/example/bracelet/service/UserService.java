package com.example.bracelet.service;

import com.example.bracelet.Response.LoginMessage;
import com.example.bracelet.model.User;
import com.example.bracelet.dto.UserRegistrationDto;
import com.example.bracelet.dto.logindto;

public interface UserService {
    User save(UserRegistrationDto registrationDto);
    LoginMessage loadUserByIdbracelet(logindto logindto);
    User getUserByIdbracelet(String idbracelet);

}

