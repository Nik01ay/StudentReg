package com.example.StudentReg;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Hashtable;
import java.util.stream.Collectors;

@Repository
@Component

public class StudentRepo implements TextFileInteface {


    private Hashtable<Integer, StudentEntity> studentEntityHashTable = new Hashtable<>();


    public Hashtable<Integer, StudentEntity> getStudentEntityHashTable() {
        return studentEntityHashTable;
    }

    public void setStudentEntityHashTable(Hashtable<Integer, StudentEntity> studentEntityHashTable) {
        this.studentEntityHashTable = studentEntityHashTable;
    }


    public StudentRepo() {


    }

    public String saveToFile(String filename) {
        createFileWithContent(filename, studentEntityHashTable.values().stream().map(StudentEntity::toString).collect(Collectors.toList()));
        return filename;
    }

    public String saveToDefaultFile() {
        return saveToFile("default.txt");
    }

    public int loadFromFile(String filename) {

        readFile(filename).forEach(s -> addStudent(StudentConvertor.stringToStudent(s)));
        return studentEntityHashTable.size();
    }


    public int getSize() {
        return studentEntityHashTable.size();
    }

    public int addStudent(StudentEntity student) {
        if (student != null) {
            Integer id = studentEntityHashTable.size();
            while (studentEntityHashTable.containsKey(id)) {
                id++;
            }
            studentEntityHashTable.put(id, student);

        }
        return studentEntityHashTable.size();
    }

    public int deleteStudent(StudentEntity student) {
        studentEntityHashTable.remove(student.getId());

        return studentEntityHashTable.size();
    }

    public int deleteStudentById(Integer id) {
       if (studentEntityHashTable.containsKey(id))
    {
        studentEntityHashTable.remove(id);
    }
        return studentEntityHashTable.size();
    }

    public StudentEntity getStudentById(Integer id) {
        return studentEntityHashTable.getOrDefault(id, null);
    }

    public void deleteAll() {
        studentEntityHashTable.clear();
    }
}