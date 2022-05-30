package com.exercise.userapi.controller;

import com.exercise.userapi.dto.UserRequest;
import com.exercise.userapi.dto.UserResponse;
import com.exercise.userapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest user){
        UserResponse createdUser = userService.create(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setCpf(createdUser.getCpf());
        return userResponse;
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@RequestBody UserRequest user) {
        UserResponse updateUser = userService.update(user);
        return updateUser;
    }
    //todo: verificar relacionamento com api de vendas, o que eh pra trazer?
    /*
    @GetMapping
    public List<OrderId>*/
}
