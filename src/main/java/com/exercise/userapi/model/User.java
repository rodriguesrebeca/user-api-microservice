package com.exercise.userapi.model;

import com.exercise.userapi.dto.UserRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    private String id = UUID.randomUUID().toString();
    @Column(name = "name")
    private String name;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone-number")
    private String phoneNumber;

    //todo: verificar se mantem cascade
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderId> orderIds;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FinishedOrderId> finishedOrderIds;

    public User (UserRequest usuarioRequest) {
        cpf = usuarioRequest.getCpf();
        name = usuarioRequest.getName();
        email = usuarioRequest.getEmail();
        password = usuarioRequest.getPassword();
        phoneNumber = usuarioRequest.getPhoneNumber();
    }
}
