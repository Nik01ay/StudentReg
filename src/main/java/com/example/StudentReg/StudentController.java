package com.example.StudentReg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class StudentController {
    private final StudentRepo studentRepo;

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentRepo studentRepo, StudentService studentService) {
        this.studentRepo = studentRepo;
        this.studentService = studentService;
    }

    @ShellMethod(key = "c")
    public void createStudent(@ShellOption(value = "fn") String firstName,
                              @ShellOption(value = "ln") String lastName,
                              @ShellOption(value = "g") Integer age) {
        studentService.addNewStudent(firstName, lastName, age);
    }

    @ShellMethod(key = "r")
    public void printStudent(Integer id) {
        studentService.print(id);
    }


    @ShellMethod(key = "u")
    public void updateStudent(@ShellOption(value = "id") Integer id,
                              @ShellOption(value = "fn") String firstName,
                              @ShellOption(value = "ln") String lastName,
                              @ShellOption(value = "g") Integer age) {
        studentService.update(id, firstName, lastName, age);
    }

    @ShellMethod(key = "d")
    public void dellById(Integer id) {
        studentService.dellById(id);

    }
    @ShellMethod(key = "da")
    public void dellAll() {
        studentService.dellAll();

    }

    @ShellMethod(key = "p")
    public void printAllStudents() {
        studentService.print();
    }
}
