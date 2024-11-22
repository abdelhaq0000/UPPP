package com.example.bracelet.service;
import java.util.Optional;
import com.example.bracelet.Response.LoginMessage;
import com.example.bracelet.model.Role;
import com.example.bracelet.model.User;
import com.example.bracelet.repository.UserRepository;
import com.example.bracelet.dto.UserRegistrationDto;
import com.example.bracelet.dto.logindto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByIdbracelet(String idbracelet) {
        return userRepository.findByIdbracelet(idbracelet);
    }


    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }



    @Override

    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getIdbracelet(),
                registrationDto.getFirstName(), registrationDto.getLastName(),
                registrationDto.getMobilenumber(), registrationDto.getDateofbirth(),
                registrationDto.getRelativeMobileNumber(),
                registrationDto.getPassword(),
                new Role("ROLE_USER"));

        // Save the user entity in the database
        return userRepository.save(user);
    }





    public LoginMessage loadUserByIdbracelet(logindto logindto)  {
        User user = userRepository.findByIdbracelet(logindto.getIdbracelet());
        System.out.println("User found: " + user); // Log the result
        if (user != null) {
            String password = logindto.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwdRight =password.equals(encodedPassword);
            if (isPwdRight) {
                Optional<User> loggedInUser = userRepository.findOneByIdbraceletAndPassword(logindto.getIdbracelet(), encodedPassword);
                if (loggedInUser.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("Password Not Match", false);
            }
        } else {
            return new LoginMessage("ID not exists", false);
        }
    }
}


