package LMS.LearningManagementSystem.repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import LMS.LearningManagementSystem.model.Attendance;
// import LMS.LearningManagementSystem.model.Lesson;

public interface AttendanceRepository extends JpaRepository<Attendance,Integer> {
    // List<Attendance>findByLesson(Lesson lesson);
}
