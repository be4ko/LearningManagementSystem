package LMS.LearningManagementSystem.repository;

import LMS.LearningManagementSystem.model.Instructor;
import LMS.LearningManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InsturctorRepository extends JpaRepository<Instructor, Integer> {
    Optional<Instructor> findByEmail(String email);

}