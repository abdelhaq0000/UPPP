package com.example.bracelet.repository;

import com.example.bracelet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByIdbracelet(String idbracelet);
    Optional<User> findOneByIdbraceletAndPassword(String idbracelet, String password);


}
