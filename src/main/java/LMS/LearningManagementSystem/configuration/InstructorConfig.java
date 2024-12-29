package LMS.LearningManagementSystem.configuration;

import LMS.LearningManagementSystem.model.Instructor;
import LMS.LearningManagementSystem.model.Role;
import LMS.LearningManagementSystem.repository.InsturctorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InstructorConfig {
    @Bean (name = "instructorCommandLineRunner")
    CommandLineRunner commandLineRunner(InsturctorRepository repository){
        return args -> {};
    }
}
