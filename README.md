# JPA-StudentManagement
This project is a simple **Student Course Management System** implemented using **Java Persistence API (JPA)**. It allows students to enroll in courses, view their class schedules, and provides basic functionality for managing student-course relationships.

## Entity Classes

1. **Student**:
   - Attributes: `id`, `studentNumber`, `name`, `gender`, `age`, `class`
   - Represents student information.

2. **Course**:
   - Attributes: `id`, `courseName`, `semester`
   - Represents course details.

3. **Teacher**:
   - Attributes: `id`, `name`, `gender`
   - Represents teacher information.

4. **CourseOffering**:
   - Attributes: `id`, `courseId`, `teacherId`, `schedule` (day and time)
   - Represents course offerings (which course is taught by which teacher at what time).

5. **Enrollment**:
   - Attributes: `id`, `offeringId`, `studentId`
   - Represents student enrollment in a specific course offering.

## Functionality

1. **Student Enrollment**:
   - Students can select and enroll in available courses.

2. **Teacher's Students**:
   - Query information about students enrolled in courses taught by a specific teacher.

3. **Student Schedule**:
   - Retrieve the class schedule for a particular student.

## Framework Used

This project is built using **Spring Boot**, which simplifies the development of Java applications. Spring Boot provides a robust foundation for creating web-based applications, including RESTful APIs and database interactions.

## Dependencies

- **Spring Boot**: Version 3.2.4
- **JDK/JAR**: 21
- **Other Dependencies**: Refer to the `pom.xml` file for additional libraries used.

## Note

- This project is intended as a student assignment and focuses on basic functionality.
- Please be aware that there may be some inaccuracies or simplifications.

Feel free to explore and enhance this project! If you have any questions or need further assistance, don't hesitate to ask. Good luck! 🌟
