package com.example.StudentReg;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@Profile("init")
public class StudentLoader {

    private final String path;
@Autowired
    private StudentRepo studentRepo;
    public StudentLoader(String path) {
        this.path = path;
    }

    @PostConstruct
    public void loadFromFile() {
        System.out.println("zagruska from server: "  + path);
         if (path != null) {
            studentRepo.loadFromFile(path);
        }
    }
}
