package LMS.LearningManagementSystem.configuration;

import LMS.LearningManagementSystem.model.Admin;
import LMS.LearningManagementSystem.repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AdminConfig {
    @Bean (name = "adminCommandLineRunner")
    CommandLineRunner commandLineRunner(AdminRepository repository){
        return args -> {
            Admin Ehab = new Admin(985,"Ehab","Basher280@gmail","123123");
            Admin Reda = new Admin(065,"Reda","Lamia@gmail","123123");
            repository.saveAll(List.of(Ehab,Reda));
        };
    }
}
