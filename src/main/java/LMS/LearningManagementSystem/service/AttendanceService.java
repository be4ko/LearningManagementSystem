package LMS.LearningManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LMS.LearningManagementSystem.model.Attendance;
import LMS.LearningManagementSystem.model.Lesson;
import LMS.LearningManagementSystem.model.Student;
import LMS.LearningManagementSystem.repository.AttendanceRepository;
import LMS.LearningManagementSystem.repository.LessonRepository;
import LMS.LearningManagementSystem.repository.StudentRepository;

@Service
public class AttendanceService {
    
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Attendance markAnAttendance(int lessonId, int studentId, String otp){
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        if (!lesson.getActive() || lesson.getOtp()!=Integer.parseInt(otp)) {
            throw new RuntimeException("Invalid OTP or lesson is inactive");
        }

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Attendance attendance = new Attendance();
        attendance.setLessons(lesson);;
        attendance.setStudent(student);
        attendance.setAttended(true);

        return attendanceRepository.save(attendance);
    }

}

