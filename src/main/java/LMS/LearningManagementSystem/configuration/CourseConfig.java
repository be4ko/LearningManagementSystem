package LMS.LearningManagementSystem.configuration;

import LMS.LearningManagementSystem.model.Course;
import LMS.LearningManagementSystem.model.Instructor;
import LMS.LearningManagementSystem.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CourseConfig {
    @Bean (name = "courseCommandLineRunner")
    CommandLineRunner commandLineRunner(CourseRepository repository){
        Instructor beeko = new Instructor(554,"Basher","Basher280@gmail","123123");
            Instructor ahmed = new Instructor(996,"Lamia","Lamia@gmail","123123");
        return args -> {
            Course Software = new Course(2,"Software","jkdsbhbcs",5,beeko);
            Course Datastructure = new Course(3,"Data Structure","cdhjvhjv",6,ahmed);
            repository.saveAll(List.of(Software,Datastructure));
        };
    }
}
