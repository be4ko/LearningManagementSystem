package LMS.LearningManagementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Collection;

@Entity
@Table(name = "instructors")
@AllArgsConstructor
@NoArgsConstructor
public class Instructor extends User{
    @OneToMany(mappedBy = "instructor")
    private List<Course> createdCourses;
    @Enumerated(EnumType.STRING)
    protected Role role;

    public Instructor(int id, String name, String email, String password) {
        super(id, name, email, password);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
}
