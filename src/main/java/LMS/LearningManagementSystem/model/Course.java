package LMS.LearningManagementSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    protected int courseID;
    @Column(nullable = false) // Ensure course name cannot be null
    protected String courseTitle;

    @Column(nullable = true) // Ensure course name cannot be null
    protected int courseDuration;

    @ManyToOne // Each course is associated with one instructor
    @JoinColumn(name = "instructor_id") // Foreign key in the courses table
    private Instructor instructor;


    public Course(int courseID, String courseTitle, int courseDuration ){
        this.courseID = courseID;
        this.courseTitle = courseTitle;
        this.courseDuration = courseDuration ;
    }

    protected Course() {

    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
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
