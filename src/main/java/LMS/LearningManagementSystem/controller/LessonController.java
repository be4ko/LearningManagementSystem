package LMS.LearningManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import LMS.LearningManagementSystem.model.Lesson;
import LMS.LearningManagementSystem.service.LessonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/lessons")
public class LessonController {
    private final LessonService lessonService;
    
    @Autowired
    public LessonController(LessonService lessonService){
        this.lessonService=lessonService;
    }

    @PostMapping("/add")
    public Lesson createLesson(@RequestParam int courseId,@RequestParam String title) {
        return this.lessonService.createLesson(courseId, title);
    }

    @PostMapping("/generateOtp")
    public int generateOtp(@RequestParam int courseId) {
        return this.lessonService.generateOtp(courseId);
    }

    @PutMapping("/inactiveLesson")
    public Lesson inactiveLesson(@RequestParam int lessonId) {
        return this.lessonService.inactiveLesson(lessonId);
}


    
    




}
