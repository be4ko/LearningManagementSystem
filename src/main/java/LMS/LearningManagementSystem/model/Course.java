package LMS.LearningManagementSystem.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int courseID;
    @Column(nullable = false) // Ensure course name cannot be null
    protected String courseTitle;

    @Column(nullable = true) // Ensure course name cannot be null
    protected String courseDescription;

    @Column(nullable = true) // Ensure course name cannot be null
    protected int courseDuration;

    @OneToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    private List<Lesson> lessons = new ArrayList<>();

    @ManyToOne // Each course is associated with one instructor
    @JoinColumn(name = "instructor_id",nullable =false) // Foreign key in the courses table
    private Instructor instructor;

    @ManyToMany(mappedBy = "courses")
    private List<Student> enrolledStudents = new ArrayList<>();


    @ElementCollection
    @CollectionTable(name = "course_media", joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "media_url")
    private List<String> mediaFiles = new ArrayList<>();


    public Course(int id,String courseTitle, String courseDescription, int courseDuration,Instructor instructor) {
        this.courseID=id;
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
        this.courseDuration = courseDuration;
        this.instructor=instructor;
    }

    protected Course() {

    }


    public int getCourseID() {
        return this.courseID;
    }



    public String getCourseTitle() {
        return this.courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDescription() {
        return this.courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getCourseDuration() {
        return this.courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public Instructor getInstructor() {
        return this.instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getEnrolledStudents() {
        return this.enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
    
    public List<String> getMediaFiles(){
        return this.mediaFiles;
    }
}
