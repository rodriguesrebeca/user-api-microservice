package com.exercise.userapi.dto;

import com.exercise.userapi.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserRequest {
    private String name;
    private String cpf;
    private String password;
    private String phoneNumber;
    private String email;
    private String id;

    public UserRequest(User user) {
        name = user.getName();
        cpf = user.getCpf();
        password = user.getPassword();
        phoneNumber = user.getPhoneNumber();
        email = user.getEmail();
    }
}
