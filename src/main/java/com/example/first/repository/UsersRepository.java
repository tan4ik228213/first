package com.example.first.repository;

import com.example.first.models.Users;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository <Users,Integer>{
Users users = new Users();
    Users getUsersById (int id);

    Users deleteById (int id);


    Users updateUsersById (int id, Users users);

    @Query(value = "SELECT * FROM users" , nativeQuery = true)
    List<Users> getAll ();
}
