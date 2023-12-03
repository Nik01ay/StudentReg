package com.example.StudentReg;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
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

        List<String> stlist = readFile(filename);

        if (!stlist.isEmpty()) {
            stlist.forEach(s -> addStudent(StudentConvertor.stringToStudent(s)));
        }

        return studentEntityHashTable.size();
    }


    public int getSize() {
        return studentEntityHashTable.size();
    }

    public int addStudent(StudentEntity student) {
        if (student != null) {
            Integer id;
            if ((student.getId() == null) || (student.getId() == 0)) {
                if (studentEntityHashTable.size()>0) {
                    id = Collections.max(studentEntityHashTable.keySet()) + 1; // получаем максимальный ключ и увеличиваем на 1
                }
                else id = 1;
            } else {
                id = student.getId();
            }
            student.setId(id);
            studentEntityHashTable.put(id, student);
        }
        assert student != null;
        return student.getId();
    }


    public int deleteStudent(StudentEntity student) {
        studentEntityHashTable.remove(student.getId());

        return studentEntityHashTable.size();
    }

    public Boolean deleteStudentById(Integer id) {
        if (studentEntityHashTable.containsKey(id)) {
            studentEntityHashTable.remove(id);
            return true;
        }

        return false;
    }

    public StudentEntity getStudentById(Integer id) {
        return studentEntityHashTable.getOrDefault(id, null);
    }

    public void deleteAll() {
        studentEntityHashTable.clear();
    }
}