package LMS.LearningManagementSystem.Authentication;

import LMS.LearningManagementSystem.model.Student;
import LMS.LearningManagementSystem.repository.StudentRepository;
import LMS.LearningManagementSystem.service.JWTServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTServices jwtServices;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(RegisterRequest request) {
        var student = Student.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        studentRepository.save(student);
        var jwtToken = jwtServices.generateToken(student);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var student = studentRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtServices.generateToken(student);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
