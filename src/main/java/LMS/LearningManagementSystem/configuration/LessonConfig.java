// package LMS.LearningManagementSystem.configuration;

// import java.util.List;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import LMS.LearningManagementSystem.model.Course;
// // import LMS.LearningManagementSystem.model.Instructor;
// import LMS.LearningManagementSystem.model.Lesson;
// import LMS.LearningManagementSystem.repository.CourseRepository;
// import LMS.LearningManagementSystem.repository.LessonRepository;

// @Configuration
// public class LessonConfig {
//     @Bean (name = "lessonCommandLineRunner")
//     CommandLineRunner commandLineRunner(LessonRepository repository, CourseRepository courseRepository) {
//         return args -> {
//             Course software = courseRepository.findById(2)
//                     .orElseThrow(() -> new RuntimeException("Course with ID 2 not found"));
//             Course dataStructure = courseRepository.findById(3)
//                     .orElseThrow(() -> new RuntimeException("Course with ID 3 not found"));

//             Lesson lesson1 = new Lesson(1, "Introduction to Software", software,1234,true);
//             Lesson lesson2 = new Lesson(2, "Advanced Software Concepts", software,8475,true);
//             Lesson lesson3 = new Lesson(3, "Data Structure Basics", dataStructure,8645,false);
//             Lesson lesson4 = new Lesson(4, "Complex Data Structures", dataStructure,8473,true);

//             repository.saveAll(List.of(lesson1, lesson2, lesson3, lesson4));
//         };
//     }
// }
