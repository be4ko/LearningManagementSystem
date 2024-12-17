package LMS.LearningManagementSystem.configuration;

import LMS.LearningManagementSystem.model.Instructor;
import LMS.LearningManagementSystem.repository.InsturctorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InstructorConfig {
    @Bean (name = "instructorCommandLineRunner")
    CommandLineRunner commandLineRunner(InsturctorRepository repository){
        return args -> {
            Instructor beeko = new Instructor(554,"Basher","Basher280@gmail","123123");
            Instructor ahmed = new Instructor(996,"Lamia","Lamia@gmail","123123");
            repository.saveAll(List.of(beeko,ahmed));
        };
    }
}
