package LMS.LearningManagementSystem.configuration;

import LMS.LearningManagementSystem.model.Student;
import LMS.LearningManagementSystem.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

import java.util.List;

@Configuration
public class StudentConfig {
    @Bean (name = "studentCommandLineRunner")
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
                Student beeko = new Student(2020,"Beeko","beeko280@gmail","123123");
                Student ahmed = new Student(2021,"Ahmed","ahmed@gmail","123123");
                repository.saveAll(List.of(beeko,ahmed));
        };
    }
}
