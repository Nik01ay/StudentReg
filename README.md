# Student Registration Application

This is a simple command-line application for registering students. It allows you to create, read, update and delete student records.
Это простое приложение командной строки для регистрации студентов. Он позволяет создавать, читать, обновлять и удалять записи учащихся.
## Usage

To use the application, run the com.example.StudentReg.StudentController class. This will start the Spring Shell and allow you to interact with the application.
Чтобы использовать приложение, запустите класс com.example.StudentReg.StudentController. Это запустит Spring Shell и позволит вам взаимодействовать с приложением.
### Commands

The following commands are available:
Доступны следующие команды:

- c - Create a new student record. Requires the following options:
    - fn - First name of the student.
    - ln - Last name of the student.
    - g - Age of the student.
- r - Read a student record by ID. Requires the following option:
    - id - ID of the student to read.
- u - Update an existing student record. Requires the following options:
    - id - ID of the student to update.
    - fn - New first name of the student.
    - ln - New last name of the student.
    - g - New age of the student.
- d - Delete a student record by ID. Requires the following option:
    - id - ID of the student to delete.
- da - Delete all student records.
- p - Print all student records.

## Dependencies

This application uses Spring Boot and Spring Shell. The following dependencies are required:
Это приложение использует Spring Boot и Spring Shell. Требуются следующие зависимости:


- org.springframework.boot:spring-boot-starter
- org.springframework.shell:spring-shell-starter