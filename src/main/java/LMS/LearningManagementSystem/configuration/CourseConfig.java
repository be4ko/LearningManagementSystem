package LMS.LearningManagementSystem.configuration;

import LMS.LearningManagementSystem.model.Course;
import LMS.LearningManagementSystem.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CourseConfig {
    @Bean (name = "courseCommandLineRunner")
    CommandLineRunner commandLineRunner(CourseRepository repository){
        return args -> {
            Course Software = new Course(2,"Software",5);
            Course Datastructure = new Course(3,"Data Structure",6);
            repository.saveAll(List.of(Software,Datastructure));
        };
    }
}
