package LMS.LearningManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import LMS.LearningManagementSystem.model.Attendance;
import LMS.LearningManagementSystem.service.AttendanceService;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {

    final private AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;

    }

    @PostMapping("/addAttendance")
    public Attendance markAttendance(@RequestParam int lessonId,
            @RequestParam int studentId,
            @RequestParam String otp) {
        return attendanceService.markAnAttendance(lessonId, studentId, otp);
    }
}