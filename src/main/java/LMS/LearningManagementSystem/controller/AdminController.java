package LMS.LearningManagementSystem.controller;

import LMS.LearningManagementSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    @Autowired
    AdminController(AdminService adminService){this.adminService = adminService;}

    @PostMapping("/add-student")
    public String addStudent(@RequestParam int id, @RequestParam String name, @RequestParam String email, @RequestParam String password) {
        adminService.addStudent(id, name, email, password);
        return "Student added successfully!";
    }
    @PostMapping("/add-course")
    public String addCourseToStudent(@RequestParam int studentId, @RequestParam int courseId) {
        return "Course added successfully to the student!";
    }

    @PostMapping("/remove-course")
    public String removeCourseFromStudent(@RequestParam int studentId, @RequestParam int courseId) {
        return "Course removed successfully from the student!";
    }
}
