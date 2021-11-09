package com.example.examportal.entityes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", user=" + user +
                ", role=" + role +
                '}';
    }

    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
@ManyToOne(fetch = FetchType.EAGER)
    private User user;
@ManyToOne(fetch = FetchType.LAZY)
private Role role;
}
