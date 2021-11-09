package com.example.examportal.services;

import com.example.examportal.Repositories.RoleRepository;
import com.example.examportal.Repositories.UserRepository;
import com.example.examportal.entityes.User;
import com.example.examportal.entityes.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpal implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User CreateUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if (local!=null){
            System.out.println("user already exists");
            throw new Exception("user already exists");
        }else {
            for (UserRole ur:userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User findUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public String Delete(Integer id) {
        this.userRepository.deleteById(id);
        return null;
    }
}
