package LMS.LearningManagementSystem.controller;

import LMS.LearningManagementSystem.model.Assignment;
import LMS.LearningManagementSystem.model.AssignmentLog;
import LMS.LearningManagementSystem.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/add")
    public Assignment addAssignment(@RequestBody Assignment assignment) {
        return assignmentService.addAssignment(assignment);
    }

    @PutMapping("/edit-grade/{assignmentId}/{grade}")
    public void editAssignmentGrade(@PathVariable Integer assignmentId, @PathVariable Integer grade) {
        assignmentService.editAssignmentGrade(assignmentId, grade);
    }

    @DeleteMapping("/delete/{assignmentId}")
    public void deleteAssignment(@PathVariable Integer assignmentId) {
        assignmentService.deleteAssignment(assignmentId);
    }

    @PostMapping("/submit")
    public void submitAssignment(@RequestParam String token, @RequestParam Integer assignmentId, @RequestParam String answeredPdf) {
        assignmentService.submitAssignment(token, assignmentId, answeredPdf);
    }

    @GetMapping("/logs")
    public List<AssignmentLog> viewAllAssignmentLogs() {
        return assignmentService.viewAllAssignmentLogs();
    }

    @GetMapping("/logs/{assignmentId}")
    public List<AssignmentLog> viewAllAssignmentLogsForSpecificAssignment(@PathVariable Integer assignmentId) {
        return assignmentService.viewAllAssignmentLogsForSpecificAssignment(assignmentId);
    }

    @GetMapping("/uncorrected-logs")
    public List<AssignmentLog> viewUncorrectedAssignmentLogs() {
        return assignmentService.viewUncorrectedAssignmentLogs();
    }

    @GetMapping("/uncorrected-logs/{assignmentId}")
    public List<AssignmentLog> viewUncorrectedAssignmentLogsForSpecificAssignment(@PathVariable Integer assignmentId) {
        return assignmentService.viewUncorrectedAssignmentLogsForSpecificAssignment(assignmentId);
    }

    @PutMapping("/correct/{assignmentLogId}/{grade}")
    public void correctAssignmentLog(@PathVariable Integer assignmentLogId, @PathVariable Integer grade) {
        assignmentService.correctAssignmentLog(assignmentLogId, grade);
    }
}
