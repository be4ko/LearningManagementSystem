package LMS.LearningManagementSystem.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
public class Instructor extends User{
    @OneToMany(mappedBy = "instructor")
    private final List<Course> createdCourses;

    public Instructor(int id, String name, String email, String password) {
        super(id, name, email, password);
        this.createdCourses = new ArrayList<>();
    }
    protected Instructor() {
        super();
        this.createdCourses = new ArrayList<>();
    }
    
}
