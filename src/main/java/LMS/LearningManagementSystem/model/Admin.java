package LMS.LearningManagementSystem.model;

import LMS.LearningManagementSystem.repository.StudentRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Collection;


@Entity
@Table(name = "admins")
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends User {
    @Enumerated(EnumType.STRING)
    private Role role ;

    public Admin(int id, String name, String email, String password) {
        super(id, name, email, password);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

}