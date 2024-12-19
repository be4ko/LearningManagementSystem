package LMS.LearningManagementSystem.repository;

import LMS.LearningManagementSystem.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
}