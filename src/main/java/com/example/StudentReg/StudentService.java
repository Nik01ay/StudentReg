package com.example.StudentReg;

import com.example.StudentReg.event.MyEvent;
import jakarta.annotation.PostConstruct;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.yaml.snakeyaml.tokens.Token.ID.Value;

@Component

public class StudentService {

    @Autowired

    private StudentRepo studentRepo;

    private final ApplicationEventPublisher publisher;





    public StudentService(ApplicationEventPublisher publisher
                          )
    {
        this.publisher = publisher;

    }

    public void print() {
        MyEvent event = new MyEvent(this, "students: ");
        publisher.publishEvent(event);
        studentRepo.getStudentEntityHashTable().forEach((integer, student) -> System.out.println(student.toString()));

    }

    public void print(Integer id) {

        MyEvent event = new MyEvent(this, "student: ");
        publisher.publishEvent(event);
        System.out.println(studentRepo.getStudentById(id));

    }

    public int dellById(Integer id) {

        if (studentRepo.deleteStudentById(id)) {

            MyEvent event = new MyEvent(this, "student delete id=" + id);
            publisher.publishEvent(event);
        }
        else {
            MyEvent eventNotFound = new MyEvent(this, "student not found id=" + id);
            publisher.publishEvent(eventNotFound);
        }
        return studentRepo.getStudentEntityHashTable().size();

    }

    public int add(String studentString) {
        MyEvent event = new MyEvent(this, "add student");
        publisher.publishEvent(event);
        return studentRepo.addStudent(StudentConvertor.stringToStudent(studentString));
    }

    public int addNewStudent(String firstName, String lastName, Integer age) {

        // studentRepo.getStudentEntityHashTable().

        StudentEntity student = new StudentEntity( firstName, lastName, age);

        studentRepo.addStudent(student);

        MyEvent event = new MyEvent(this, "add new student " + student);
        publisher.publishEvent(event);
        return studentRepo.getSize();
    }

    public String save(String fileName) {
        if (fileName.isEmpty()) {
            MyEvent event = new MyEvent(this, "students save default file");
            publisher.publishEvent(event);
            return studentRepo.saveToDefaultFile();

        } else {
            MyEvent event = new MyEvent(this, "students save file " + fileName);
            publisher.publishEvent(event);
            return studentRepo.saveToFile(fileName);
        }

    }

    public void update(Integer id, String firstName, String lastName, Integer age) {

        StudentEntity student = studentRepo.getStudentById(id);
        if (student != null) {
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setAge(age);
            MyEvent event = new MyEvent(this, "student update");
            publisher.publishEvent(event);
        }

    }

    public void dellAll() {
        studentRepo.deleteAll();
        MyEvent event = new MyEvent(this, "all students delete");
        publisher.publishEvent(event);

    }


}
