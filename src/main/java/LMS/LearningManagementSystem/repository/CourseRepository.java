package LMS.LearningManagementSystem.repository;

import LMS.LearningManagementSystem.model.Course;
import LMS.LearningManagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}