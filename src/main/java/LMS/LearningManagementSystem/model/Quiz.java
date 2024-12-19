package LMS.LearningManagementSystem.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "quizes")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer courseId;

    private String quizTitle;

    @ElementCollection
    @CollectionTable(name = "quiz_questions", joinColumns = @JoinColumn(name = "quiz_id"))
    private List<Question> quizQuestions;

    private Integer totalGrade;

    // Constructors
    public Quiz() {}

    public Quiz(Integer courseId, String quizTitle, List<Question> quizQuestions, Integer totalGrade) {
        this.courseId = courseId;
        this.quizTitle = quizTitle;
        this.quizQuestions = quizQuestions;
        this.totalGrade = totalGrade;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public List<Question> getQuizQuestions() {
        return quizQuestions;
    }

    public void setQuizQuestions(List<Question> quizQuestions) {
        this.quizQuestions = quizQuestions;
    }

    public Integer getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(Integer totalGrade) {
        this.totalGrade = totalGrade;
    }

    public static class Question {
        private String title;
        private String rightAnswer;
        private Integer grade;

        // Constructors
        public Question() {}

        public Question(String title, String rightAnswer, Integer grade) {
            this.title = title;
            this.rightAnswer = rightAnswer;
            this.grade = grade;
        }

        // Getters and Setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getRightAnswer() {
            return rightAnswer;
        }

        public void setRightAnswer(String rightAnswer) {
            this.rightAnswer = rightAnswer;
        }

        public Integer getGrade() {
            return grade;
        }

        public void setGrade(Integer grade) {
            this.grade = grade;
        }
    }
}
