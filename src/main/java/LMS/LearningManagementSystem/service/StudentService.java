package LMS.LearningManagementSystem.service;

import LMS.LearningManagementSystem.model.Student;
import LMS.LearningManagementSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){ // مفروض ترجع من الDatabase
        return studentRepository.findAll();

    }
}
