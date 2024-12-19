package LMS.LearningManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LMS.LearningManagementSystem.model.Course;
import LMS.LearningManagementSystem.model.Lesson;
import LMS.LearningManagementSystem.repository.CourseRepository;
import LMS.LearningManagementSystem.repository.LessonRepository;

@Service
public class LessonService {
    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    CourseRepository courseRepository;



        public Lesson createLesson(int courseId, String title) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found!"));

        Lesson lesson = new Lesson();
        lesson.setTitle(title);
        lesson.setCourses(course);

        return lessonRepository.save(lesson);
    }


    public int generateOtp(int lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found!"));

        int otp = (int) (Math.random() * 9000) + 1000;
        lesson.setOtp(otp);;

        lessonRepository.save(lesson);
        return otp;
    }


    public Lesson inactiveLesson(int lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        lesson.setActive(false);
        return lessonRepository.save(lesson);
    }
}
