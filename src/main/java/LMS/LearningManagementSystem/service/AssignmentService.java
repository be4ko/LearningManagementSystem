package LMS.LearningManagementSystem.service;


import LMS.LearningManagementSystem.model.Assignment;
import LMS.LearningManagementSystem.model.AssignmentLog;
import LMS.LearningManagementSystem.repository.AssignmentRepository;
import LMS.LearningManagementSystem.repository.AssignmentLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private AssignmentLogRepository assignmentLogRepository;

    public Assignment addAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public void editAssignmentGrade(Integer assignmentId, Integer grade) {
        Assignment assignment = assignmentRepository.findById(assignmentId).orElseThrow();
        assignment.setGrade(grade);
        assignmentRepository.save(assignment);
    }

    public void deleteAssignment(Integer assignmentId) {
        assignmentRepository.deleteById(assignmentId);
    }

    public void submitAssignment(String token, Integer assignmentId, String answeredPdf) {
        // Extract student ID from token (pseudo code)
        Integer studentId = extractStudentIdFromToken(token);

        // Create an assignment log
        Assignment assignment = assignmentRepository.findById(assignmentId).orElseThrow();
        AssignmentLog log = new AssignmentLog();
        log.setStudentId(studentId);
        log.setAnsweredPdfPath(answeredPdf);
        log.setAssignment(assignment);
        assignmentLogRepository.save(log);
    }

    public List<AssignmentLog> viewAllAssignmentLogs() {
        return assignmentLogRepository.findAll();
    }

    public List<AssignmentLog> viewAllAssignmentLogsForSpecificAssignment(Integer assignmentId) {
        return assignmentLogRepository.findAll().stream()
                .filter(log -> log.getAssignment().getId().equals(assignmentId))
                .toList();
    }

    public List<AssignmentLog> viewUncorrectedAssignmentLogs() {
        return assignmentLogRepository.findAll().stream()
                .filter(log -> log.getGrade() == null)
                .toList();
    }

    public List<AssignmentLog> viewUncorrectedAssignmentLogsForSpecificAssignment(Integer assignmentId) {
        return assignmentLogRepository.findAll().stream()
                .filter(log -> log.getGrade() == null && log.getAssignment().getId().equals(assignmentId))
                .toList();
    }

    public void correctAssignmentLog(Integer assignmentLogId, Integer grade) {
        AssignmentLog log = assignmentLogRepository.findById(assignmentLogId).orElseThrow();
        log.setGrade(grade);
        assignmentLogRepository.save(log);
    }

    private Integer extractStudentIdFromToken(String token) {
        // Placeholder function
        return 1;
    }
}
