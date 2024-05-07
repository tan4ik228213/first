package com.example.first.service;

import com.example.first.dto.UsersRequestDto;
import com.example.first.dto.UsersResponseDto;
import com.example.first.models.Users;
import com.example.first.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    public List<UsersResponseDto> getAll(){
        return usersRepository.findAll().stream().map(
                users -> UsersResponseDto.builder()
                        .login(users.getLogin())
                        .password(users.getPassword())
                        .firstName(users.getFirst_name())
                        .lastName(users.getLast_name())
                        .patronymicName(users.getPatronymic_name())
                        .age(users.getAge())
                        .build()

        ).collect(Collectors.toList());
    }

    public void addNewUser(UsersRequestDto usersRequestDto){
        Users insertAddUsers = Users.builder()
                .login(usersRequestDto.getLogin())
                .password(usersRequestDto.getPassword())
                .first_name(usersRequestDto.getFirstName())
                .last_name(usersRequestDto.getLastName())
                .patronymic_name(usersRequestDto.getPatronymicName())
                .age(usersRequestDto.getAge())
                .build();
        usersRepository.save(insertAddUsers);

    }

}

