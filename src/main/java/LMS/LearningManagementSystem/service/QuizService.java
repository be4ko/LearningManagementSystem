package LMS.LearningManagementSystem.service;

import LMS.LearningManagementSystem.model.Quiz;
import LMS.LearningManagementSystem.model.QuizLog;
import LMS.LearningManagementSystem.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    // Add Quiz
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    // Delete Quiz
    public void deleteQuiz(int quizId) {
        quizRepository.deleteById(quizId);
    }

    // Update Quiz Total Grade
    public Quiz updateQuizTotalGrade(int quizId, int totalGrade) {
        Optional<Quiz> quizOpt = quizRepository.findById(quizId);
        if (quizOpt.isPresent()) {
            Quiz quiz = quizOpt.get();
            quiz.setTotalGrade(totalGrade);
            return quizRepository.save(quiz);
        }
        return null; // or throw exception
    }

    // Answer Quiz
    public int answerQuiz(String token, int quizId, List<String> studentAnswers) {
        // Use token to identify student and get their ID
        // Validate student answers against quiz questions and calculate grade
        // For simplicity, we are returning a dummy grade here
        return 90; // Dummy grade
    }

    // View all Quiz Logs
    public List<QuizLog> getAllQuizLogs() {
        // Logic to fetch all quiz logs
        return null; // Implement this logic
    }

    // View all Quiz Logs for specific Quiz
    public List<QuizLog> getQuizLogsByQuizId(int quizId) {
        // Logic to fetch quiz logs for a specific quiz
        return null; // Implement this logic
    }

    // Delete Quiz Log
    public void deleteQuizLog(int quizLogId) {
        // Logic to delete quiz log by ID
    }
}
