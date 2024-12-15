package LMS.LearningManagementSystem.controller;

import LMS.LearningManagementSystem.model.Course;
import LMS.LearningManagementSystem.model.Student;
import LMS.LearningManagementSystem.repository.CourseRepository;
import LMS.LearningManagementSystem.repository.StudentRepository;
import LMS.LearningManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path= "/students")
public class StudentController {
    protected final StudentService studentService;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    @Autowired
    public StudentController(StudentService studentService,StudentRepository studentRepository,CourseRepository courseRepository ) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }


    @Autowired
    @GetMapping(path = "/get-students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping(path = "/add-course")
    public String addCourse(@RequestParam int studentId, @RequestParam int courseId){
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();

            Optional<Course> courseOptional = courseRepository.findById(courseId);
            if (courseOptional.isPresent()) {
                Course course = courseOptional.get();

                student.addCourse(course);
                studentRepository.save(student);

                return "Course added successfully!";
            } else {
                return "Course not found.";
            }
        } else {
            return "Student not found.";
        }

    }


}
