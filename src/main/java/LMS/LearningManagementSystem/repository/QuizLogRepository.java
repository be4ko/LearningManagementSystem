package LMS.LearningManagementSystem.repository;

import LMS.LearningManagementSystem.model.QuizLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizLogRepository extends JpaRepository<QuizLog, Integer> {
}