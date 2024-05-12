package com.example.first.service;

import com.example.first.dto.UsersRequestDto;
import com.example.first.dto.UsersResponseDto;
import com.example.first.models.GenderName;
import com.example.first.models.Users;
import com.example.first.repository.GenderRep;
import com.example.first.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class UsersService {

    private final UsersRepository usersRepository;
    private final GenderRep genderRep;
    public List<UsersResponseDto> getAll() {
        return usersRepository.findAll().stream().map(
                users -> UsersResponseDto.builder()
                        .login(users.getLogin())
                        .password(users.getPassword())
                        .firstName(users.getFirst_name())
                        .lastName(users.getLast_name())
                        .patronymicName(users.getPatronymic_name())
                        .age(users.getAge())
                        .gender(users.getGenderName().getGenderName())
                        .build()

        ).collect(Collectors.toList());
    }

    public void addNewUser(UsersRequestDto usersRequestDto) {
        GenderName findGenderById = genderRep.findById(usersRequestDto.getGender()).get();
        Users insertAddUsers = Users.builder()
                .login(usersRequestDto.getLogin())
                .password(usersRequestDto.getPassword())
                .first_name(usersRequestDto.getFirstName())
                .last_name(usersRequestDto.getLastName())
                .patronymic_name(usersRequestDto.getPatronymicName())
                .age(usersRequestDto.getAge())
                .genderName(findGenderById)
                .build();
        usersRepository.save(insertAddUsers);

    }

    public Users findUserById(int id) {
        return usersRepository.getUsersById(id);
    }

    public Users deleteUserById(int id) {
        return usersRepository.deleteById(id);

    }

    public List<UsersResponseDto> testGet() {
        return usersRepository.getAll().stream().map(
                users -> UsersResponseDto.builder()
                        .firstName(users.getFirst_name())
                        .lastName(users.getLast_name())
                        .patronymicName(users.getPatronymic_name())
                        .login(users.getLogin())
                        .password(users.getPassword())
                        .age(users.getAge())
                        .build()
        ).collect(Collectors.toList());



    }
    public Users patchUser (int id, UsersRequestDto usersRequestDto) {
        Users findUserFromDb = usersRepository.findUsersById(id);
        if (findUserFromDb != null) {
            findUserFromDb.setFirst_name(usersRequestDto.getFirstName());
            findUserFromDb.setLast_name(usersRequestDto.getLastName());
            findUserFromDb.setPatronymic_name(usersRequestDto.getPatronymicName());
            findUserFromDb.setLogin(usersRequestDto.getLogin());
            findUserFromDb.setPassword(usersRequestDto.getPassword());
            findUserFromDb.setAge(usersRequestDto.getAge());
            return usersRepository.save(findUserFromDb);
        } else {
            System.out.println("error");
        }
        return findUserFromDb;
    }
}
