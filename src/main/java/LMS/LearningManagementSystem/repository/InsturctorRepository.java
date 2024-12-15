package LMS.LearningManagementSystem.repository;

import LMS.LearningManagementSystem.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsturctorRepository extends JpaRepository<Instructor, Integer> {
}