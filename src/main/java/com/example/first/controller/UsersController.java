package com.example.first.controller;

import com.example.first.dto.UsersRequestDto;
import com.example.first.dto.UsersResponseDto;
import com.example.first.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/main")
public class UsersController {

    private final UsersService usersService;

    @GetMapping(value = "/all-users")
    public List<UsersResponseDto> getAllUsers() {

        return usersService.getAll();
    }

@PostMapping(value = "/add-user")
    public void insertUser(@RequestBody UsersRequestDto usersRequestDto){

        usersService.addNewUser(usersRequestDto);
}

}
