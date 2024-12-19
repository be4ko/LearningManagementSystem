package LMS.LearningManagementSystem.service;

import LMS.LearningManagementSystem.repository.InsturctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {
    private final InsturctorRepository insturctorRepository;

    @Autowired
    public InstructorService(InsturctorRepository insturctorRepository){
        this.insturctorRepository = insturctorRepository;
    }

}
