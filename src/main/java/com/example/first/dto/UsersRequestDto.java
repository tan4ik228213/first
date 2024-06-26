package com.example.first.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersRequestDto {

    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private String patronymicName;

    private int gender;

    private int age;


}
