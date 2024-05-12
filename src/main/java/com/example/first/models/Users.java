package com.example.first.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "patronymic_name")
    private String patronymic_name;

    @ManyToOne
    @JoinColumn (name = "gender_id")
    private GenderName genderName;

    @Column(name = "age")
    private int age;

}
