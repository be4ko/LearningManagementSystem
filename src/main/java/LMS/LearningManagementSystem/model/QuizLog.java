package LMS.LearningManagementSystem.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "quizLogs")

public class QuizLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer studentId;

    private Integer quizId;

    private Integer grade;

    private String dateOfSubmission;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
    // Constructors
    public QuizLog() {}

    public QuizLog(Integer studentId, Integer quizId, Integer grade, String dateOfSubmission) {
        this.studentId = studentId;
        this.quizId = quizId;
        this.grade = grade;
        this.dateOfSubmission = dateOfSubmission;
    }

    // Getters and Setters
}