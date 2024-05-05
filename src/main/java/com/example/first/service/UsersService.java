package com.example.first.service;

import com.example.first.dto.UsersResponseDto;
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

}
