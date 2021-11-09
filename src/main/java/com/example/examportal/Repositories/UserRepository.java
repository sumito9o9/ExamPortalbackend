package com.example.examportal.Repositories;

import com.example.examportal.entityes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {


    User findByUsername(String username);
}
