package LMS.LearningManagementSystem.controller;

import LMS.LearningManagementSystem.model.Course;
import LMS.LearningManagementSystem.model.Student;
// import LMS.LearningManagementSystem.model.Instructor;
// import LMS.LearningManagementSystem.repository.CourseRepository;
// import LMS.LearningManagementSystem.repository.InsturctorRepository;
// import LMS.LearningManagementSystem.repository.*;
import LMS.LearningManagementSystem.service.CourseService;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")

public class CourseController {
    private final CourseService courseService;
    // private final CourseRepository courseRepository;
    // private final InsturctorRepository insturctorRepository;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }

    @GetMapping("/allCourses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
    
    @GetMapping("/instructorCourses")
    public List<Course> getCoursesByInstructor(@RequestParam int instructorId) {
        return this.courseService.getCoursesByInstructor(instructorId);
}

    @GetMapping("/enrolledStudents")
    public List<Student> getEnrolledStudents(int courseId) {
        return this.courseService.getEnrolledStudents(courseId);
    }

}
