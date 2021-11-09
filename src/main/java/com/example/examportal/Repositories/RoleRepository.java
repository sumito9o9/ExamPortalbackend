package com.example.examportal.Repositories;

import com.example.examportal.entityes.Role;
import com.example.examportal.entityes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

}
