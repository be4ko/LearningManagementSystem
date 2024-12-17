# Learning Management System (LMS)

This Java-Based Learning Management System (LMS) is a web-based application designed to streamline the management 
and organization of online courses, assessments, and performance tracking.

## 🌟 Key Features  

### 1. User Management  
- **Roles**: Admin, Instructor, Student.  
- **Admin**: Manages users, courses, and system settings.  
- **Instructor**: Creates and manages courses, assignments, quizzes, grades, and student enrollments.  
- **Student**: Enrolls in courses, accesses materials, submits assignments, and views grades.  
- **Additional Features**:  
  - Role-based registration and login.  
  - Profile management for all users.  

### 2. Course Management  
- **Course Creation**: Add titles, descriptions, durations, and media (videos, PDFs, etc.).  
- **Enrollment**: Students can browse and enroll in courses; admins and instructors can manage enrollments.  
- **Attendance**: OTP-based attendance tracking for lessons.  

### 3. Assessments & Grading  
- **Quizzes**: MCQ, true/false, and short-answer questions, with randomized selection and question banks.  
- **Assignments**: Students can upload files for review and feedback.  
- **Grading**: Automated quiz feedback and manual assignment grading.  

### 4. Performance Tracking  
- Track progress, attendance, and grades for individual students.  

### 5. Notifications  
- Role-specific notifications for enrollment confirmations, grades, and updates.  
- Option to filter unread notifications.

---
## 🛠️ Technical Stack  

### Backend  
- **Java** with Spring Boot for RESTful APIs.  
- **Database**: PostgreSQL.  

### Testing and Security   
- **Testing**: JUnit for unit testing.  
- **Security**: JWT. 

## Project Structure
```
LMS_Project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │       └── LMS/
│   │   │           ├── configuration/               # Configuration classes (Database, Security, etc.)
│   │   │           │   ├── DatabaseConfig.java
│   │   │           │   ├── SecurityConfig.java
│   │   │           │   └── SwaggerConfig.java
│   │   │           │
│   │   │           ├── controller/           # REST Controllers for handling HTTP requests
│   │   │           │   ├── AuthController.java
│   │   │           │   ├── CourseController.java
│   │   │           │   └── StudentController.java
│   │   │           │   └── InstructorController.java
│   │   │           │   └── AdminController.java
│   │   │           │
│   │   │           ├── service/              # Business logic layer
│   │   │           │   ├── AuthService.java
│   │   │           │   ├── CourseService.java
│   │   │           │   ├── NotificationService.java
│   │   │           │   ├── AssessmentService.java
│   │   │           │   └── StudentService.java
│   │   │           │   └── InsturctorService.java
│   │   │           │   └── AdminService.java
│   │   │           │
│   │   │           ├── model/                
│   │   │           │   ├── User.java         
│   │   │           │   ├── Student.java
│   │   │           │   ├── Instructor.java
│   │   │           │   ├── Admin.java
│   │   │           │   ├── Course.java
│   │   │           │   ├── Assessment.java
│   │   │           │   ├── Quiz.java
│   │   │           │   ├── Assignment.java
│   │   │           │   └── Notification.java
│   │   │           │
│   │   │           ├── repository/           # layer for database interactions
│   │   │           │   ├── UserRepository.java
│   │   │           │   ├── CourseRepository.java
│   │   │           │   ├── AssessmentRepository.java
│   │   │           │   └── NotificationRepository.java
│   │   │           │   └── StudentRepository.java
│   │   │           │   └── InstructorRepository.java
│   │   │           │   └── AdminRepository.java
│   │   │           │
│   │   │           │
│   │   │           └── LMSApplication.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties            
│   │       └── schema.sql                        
│   │    
│   │
│   ├── test/                                    
│   │   └── java/
│   │         └── LMS/
│   │             ├── AuthServiceTest.java
│   │             ├── UserRepositoryTest.java
│   │             └── CourseControllerTest.java
│   │
├── pom.xml                                       # Maven dependencies
└── README.md                                     
```

## 🤝Contributors
- Mariam Assem
- Mina Emad
- Mahmoud Ali
- Reem Ahmed

## 📜License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
