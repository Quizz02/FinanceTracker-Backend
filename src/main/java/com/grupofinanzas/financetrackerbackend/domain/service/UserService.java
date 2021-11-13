package com.grupofinanzas.financetrackerbackend.domain.service;

import com.grupofinanzas.financetrackerbackend.domain.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    User updateUser(Long userid, User userdetails);
    ResponseEntity<?> deleteUser(Long userid);
    Optional<User> getUserById(Long userid);

}
