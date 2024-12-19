package LMS.LearningManagementSystem.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student extends User{
    @OneToMany(mappedBy = "student")
    private List<Attendance> attendances = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    public Student(int id, String name, String email, String password) {
        super(id, name, email, password);
    }
    protected Student() {
        super();
    }

    public Student(int id, String name, String email, String password, List<Course> courses) {
        super(id, name, email, password);
        this.courses = courses;
    }

    public void addCourse(Course course){                    // يجب التعديل بعد إضافة كلاس الكورس
        this.courses.add(course);
    }
    public void removeCourse(Course course){                    // يجب التعديل بعد إضافة كلاس الكورس
        this.courses.remove(course);
    }
}
