package com.example.first.repository;

import com.example.first.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository <Users,Integer>{

    Users getUsersById (int id);


}
