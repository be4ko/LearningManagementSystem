package LMS.LearningManagementSystem.model;

import LMS.LearningManagementSystem.repository.StudentRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.*;

@Entity
@Table(name = "admins") // Define the table name
public class Admin extends User {

    protected Admin() {
        super();
    }

    public Admin(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public void addCourseToStudent(Student student, Course course) {
        student.addCourse(course); // Maintains bidirectional relationship
    }

    public void removeCourseFromStudent(Student student, Course course) {
        student.removeCourse(course); // Properly handles relationship
    }

    @Override
    public Role getRole() {
        return Role.Admin;
    }
}
