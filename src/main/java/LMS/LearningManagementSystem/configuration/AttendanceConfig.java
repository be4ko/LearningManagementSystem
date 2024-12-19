// package LMS.LearningManagementSystem.configuration;

// import java.util.List;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;

// import org.springframework.context.annotation.Configuration;
// import LMS.LearningManagementSystem.model.Attendance;
// import LMS.LearningManagementSystem.model.Lesson;
// import LMS.LearningManagementSystem.model.Student;
// import LMS.LearningManagementSystem.repository.AttendanceRepository;
// import LMS.LearningManagementSystem.repository.LessonRepository;
// import LMS.LearningManagementSystem.repository.StudentRepository;

// @Configuration
// public class AttendanceConfig {
//         @Bean(name = "attendanceCommandLineRunner")
//         CommandLineRunner commandLineRunner(AttendanceRepository repository, LessonRepository lessonRepository,
//                         StudentRepository studentRepository) {
//                 return args -> {
//                         Lesson lesson1 = lessonRepository.findById(1)
//                                         .orElseThrow(() -> new RuntimeException("Lesson with ID 1 not found"));
//                         Lesson lesson2 = lessonRepository.findById(2)
//                                         .orElseThrow(() -> new RuntimeException("Lesson with ID 2 not found"));

//                         Student student1 = studentRepository.findById(2020)
//                                         .orElseThrow(() -> new RuntimeException("Student with ID 554 not found"));
//                         Student student2 = studentRepository.findById(2021)
//                                         .orElseThrow(() -> new RuntimeException("Student with ID 996 not found"));

//                         Attendance attendance1 = new Attendance(1, lesson1, student1, true);
//                         Attendance attendance2 = new Attendance(2, lesson1, student2, false);
//                         Attendance attendance3 = new Attendance(3, lesson2, student1, true);

//                         repository.saveAll(List.of(attendance1, attendance2, attendance3));
//                 };
//         }
// }
