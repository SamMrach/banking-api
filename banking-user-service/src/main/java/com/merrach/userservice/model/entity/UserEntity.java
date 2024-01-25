package com.merrach.userservice.model.entity;

import com.merrach.userservice.model.dto.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authId;

    private String identification;

    @Enumerated(EnumType.STRING)
    private Status status;

}
