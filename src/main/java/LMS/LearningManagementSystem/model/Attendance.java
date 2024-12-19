package LMS.LearningManagementSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendances")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendanceId;

    @ManyToOne
    @JoinColumn(name = "lessonId", nullable = false)
    private Lesson lessons;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(nullable = false)
    private boolean attended;


    public Attendance() {
    }

    public Attendance(int attendanceId, Lesson lessons, Student student, boolean attended) {
        this.attendanceId = attendanceId;
        this.lessons = lessons;
        this.student = student;
        this.attended = attended;
    }

    


    public int getAttendanceId() {
        return this.attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Lesson getLessons() {
        return this.lessons;
    }

    public void setLessons(Lesson lessons) {
        this.lessons = lessons;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isAttended() {
        return this.attended;
    }

    public boolean getAttended() {
        return this.attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }
    

}