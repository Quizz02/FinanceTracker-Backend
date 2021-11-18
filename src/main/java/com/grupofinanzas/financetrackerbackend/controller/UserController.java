package com.grupofinanzas.financetrackerbackend.controller;

import com.grupofinanzas.financetrackerbackend.domain.model.User;
import com.grupofinanzas.financetrackerbackend.domain.service.UserService;
import com.grupofinanzas.financetrackerbackend.resource.user.SaveUserResource;
import com.grupofinanzas.financetrackerbackend.resource.user.UserResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/users")
    public UserResource createUser(@Valid @RequestBody SaveUserResource resource){
        User user = convertToEntity(resource);
        return convertToResource(userService.createUser(user));
    }

    @GetMapping("/users/{id}")
    public UserResource getUserById(@PathVariable Long id){
        Optional<User> user = userService.getUserById(id);
        return user.map(this::convertToResource).orElse(null);
    }

    @GetMapping("/users")
    public List<UserResource> getAllUsers(){
        return userService.getAllUsers()
                .stream()
                .map(
                        user -> mapper.map(user, UserResource.class)
                ).collect(Collectors.toList());
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    private User convertToEntity(SaveUserResource resource) {
        return mapper.map(resource, User.class);
    }

    private UserResource convertToResource(User entity) {
        return mapper.map(entity, UserResource.class);
    }
}
