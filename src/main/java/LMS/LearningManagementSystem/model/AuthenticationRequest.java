package LMS.LearningManagementSystem.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticationRequest {
    private String username;
    private String password;
}
