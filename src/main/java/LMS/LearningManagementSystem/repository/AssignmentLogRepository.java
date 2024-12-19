package LMS.LearningManagementSystem.repository;

import LMS.LearningManagementSystem.model.AssignmentLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentLogRepository extends JpaRepository<AssignmentLog, Integer> {
}