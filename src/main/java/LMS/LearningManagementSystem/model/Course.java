package LMS.LearningManagementSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int courseID;
    @Column(nullable = false) // Ensure course name cannot be null
    protected String courseTitle;
    protected int courseDuration;
    @ManyToOne
    @JoinColumn(name = "student_id") // Foreign key in the courses table
    private Student student;

    @ManyToOne
    @JoinColumn(name = "insturctor_id") // Foreign key in the courses table
    private Instructor instructor;


    Course(int courseID, String courseTitle, int courseDuration ){
        this.courseID = courseID;
        this.courseTitle = courseTitle;
        this.courseDuration = courseDuration ;
    }

    protected Course() {

    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public int getCourseID() {
        return courseID;
    }
}
