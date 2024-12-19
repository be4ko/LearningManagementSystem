package LMS.LearningManagementSystem.controller;

import LMS.LearningManagementSystem.model.Course;
import LMS.LearningManagementSystem.model.Instructor;
import LMS.LearningManagementSystem.repository.InsturctorRepository;
import LMS.LearningManagementSystem.repository.CourseRepository;
import LMS.LearningManagementSystem.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/instructor")
public class InstructorController {
    protected final InstructorService instrutorService;
    protected final InsturctorRepository insturctorRepository;
    protected final CourseRepository  courseRepository;

    @Autowired
    InstructorController(InstructorService instrutorService, InsturctorRepository insturctorRepository , CourseRepository  courseRepository ){
        this.instrutorService = instrutorService;
        this.insturctorRepository = insturctorRepository;
        this.courseRepository = courseRepository;
    }

    @PostMapping(path = "/create-course")
    public String createCourse(@RequestParam int instructorId, @RequestParam int courseId , @RequestParam String courseTitle , @RequestParam int courseDuration )
    {
        Optional<Instructor> instructorOptional = insturctorRepository.findById(instructorId);

        if (instructorOptional.isEmpty()) {
            return "Instructor with ID not found.";
        }

        Instructor instructor = instructorOptional.get();

        Course course = new Course(courseId, courseTitle, courseDuration);
        course.setInstructor(instructor);

        courseRepository.save(course);

        return "Course created successfully and assigned to instructor.";

    }
    @DeleteMapping(path = "/delete-course")
    public String deleteCourse(@RequestParam int instructorId, @RequestParam int courseId) {
        Optional<Instructor> instructorOptional = insturctorRepository.findById(instructorId);

        if (instructorOptional.isEmpty()) {
            return "Instructor with ID " + instructorId + " not found.";
        }

        Optional<Course> courseOptional = courseRepository.findById(courseId);

        if (courseOptional.isEmpty()) {
            return "Course with ID  not found.";
        }

        courseRepository.deleteById(courseId);

        return "Course deleted successfully.";
    }


}
