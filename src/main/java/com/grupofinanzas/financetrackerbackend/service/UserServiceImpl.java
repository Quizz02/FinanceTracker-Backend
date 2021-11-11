package com.grupofinanzas.financetrackerbackend.service;

import com.grupofinanzas.financetrackerbackend.domain.model.User;
import com.grupofinanzas.financetrackerbackend.domain.repository.UserRepository;
import com.grupofinanzas.financetrackerbackend.domain.service.UserService;
import com.grupofinanzas.financetrackerbackend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userid, User userdetails) {
        return userRepository.findById(userid).map(user -> {
            user.setPassword(userdetails.getPassword());
            user.setName(userdetails.getName());
            user.setFatherSurname(userdetails.getFatherSurname());
            user.setMotherSurname(userdetails.getMotherSurname());
            user.setEmail(userdetails.getEmail());
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("User","Id", userid));
    }

    @Override
    public ResponseEntity<?> deleteUser(Long userid) {
        User user = userRepository.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userid));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public ArrayList<User> getAllUsers() { return (ArrayList<User>) userRepository.findAll(); }
}
