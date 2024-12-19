package LMS.LearningManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import LMS.LearningManagementSystem.model.Course;
import LMS.LearningManagementSystem.model.Instructor;
import LMS.LearningManagementSystem.model.Student;
import LMS.LearningManagementSystem.repository.CourseRepository;
import LMS.LearningManagementSystem.repository.InsturctorRepository;


@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final InsturctorRepository insturctorRepository;
    @Autowired
    public CourseService(CourseRepository courseRepository,InsturctorRepository insturctorRepository){
        this.courseRepository=courseRepository;
        this.insturctorRepository=insturctorRepository;
    }


    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }


    public List<Course> getCoursesByInstructor(@RequestParam int instructorId) {
            Instructor instructor = insturctorRepository.findById(instructorId).orElseThrow(() -> new RuntimeException("Instructor not found with id: " + instructorId));; 
        // Optional<Course> optionalCourses=courseRepository.findById(instructorId);
        // if(optionalInstructor==null){
        //     throw new RuntimeException("Instructor not found with id:" + instructorId);
        // }
        return courseRepository.findByInstructor(instructor);
    }

    public List<Student> getEnrolledStudents(int courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return course.getEnrolledStudents();
    }

}
