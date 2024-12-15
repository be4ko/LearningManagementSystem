package LMS.LearningManagementSystem.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
public class Instructor extends User{
    @OneToMany(mappedBy = "instructor") // One instructor can have multiple courses    private final List<Course> createdCourses;
    private final List<Course> createdCourses;

    public Instructor(int id, String name, String email, String password) {
        super(id, name, email, password);
        this.createdCourses = new ArrayList<>();  // Initialize the list here as well
    }

    protected Instructor() {
        super(); // Hibernate requires a no-arg constructor
        this.createdCourses = new ArrayList<>();  // Initialize the list here as well
    }
    public List<Course> getCreatedCourses() {
        return createdCourses;
    }

    public void createCourse(int courseID, String courseTitle, int CourseDuration ) {          // بعد إضافة كلاس الكورس
    Course newCourse = new Course(courseID, courseTitle, CourseDuration);
    createdCourses.add(newCourse);
    System.out.println("Course created successfully: " + newCourse.getCourseTitle());
    }

    public Role getRole(){
        return Role.Instructor;
    }
}
