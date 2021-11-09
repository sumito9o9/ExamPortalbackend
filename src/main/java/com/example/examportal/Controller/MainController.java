package com.example.examportal.Controller;

import com.example.examportal.entityes.Role;
import com.example.examportal.entityes.User;
import com.example.examportal.entityes.UserRole;
import com.example.examportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
@RestController
@RequestMapping("/user")
public class MainController {

    @Autowired
    private UserService userService;

    @PostMapping("/home")
    public User Run(@RequestBody User user) throws Exception {

        Role role = new Role();
        role.setRoleName("admin");

        Set<UserRole> userRole=new HashSet<>();
        UserRole userRole1 = new UserRole();
        userRole1.setRole(role);
        userRole1.setUser(user);
        userRole.add(userRole1);


        return this.userService.CreateUser(user,userRole);
    }
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.findUser(username);
    }
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable("id") int id){
         this.userService.Delete(id);
    }
}
