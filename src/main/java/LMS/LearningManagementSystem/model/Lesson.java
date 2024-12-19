package LMS.LearningManagementSystem.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lessonId;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "courseID", nullable = false)
    private Course courses;

    @Column
    private int otp;

    @Column
    private boolean active=true; //the lesson availablility for attendance.

    @OneToMany(mappedBy = "lessons")
    private List<Attendance> attendences = new ArrayList<>();


    public Lesson() {
    }


    public Lesson(int lessonId, String title, Course course, int otp,boolean active) {
        this.lessonId = lessonId;
        this.title = title;
        this.courses = course;
        this.otp = otp;
        this.active=active;
    }


    public int getLessonId() {
        return this.lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Course getCourses() {
        return this.courses;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }

    public int getOtp() {
        return this.otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Attendance> getAttendences() {
        return this.attendences;
    }

    public void setAttendences(List<Attendance> attendences) {
        this.attendences = attendences;
    }

}

