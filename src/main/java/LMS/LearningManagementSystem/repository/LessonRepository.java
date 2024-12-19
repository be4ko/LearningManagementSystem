package LMS.LearningManagementSystem.repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// import LMS.LearningManagementSystem.model.Course;
import LMS.LearningManagementSystem.model.Lesson;

public interface LessonRepository extends JpaRepository <Lesson,Integer>{
    // List<Lesson>findByCourse(Course course);
}
