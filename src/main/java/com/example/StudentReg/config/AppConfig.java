package com.example.StudentReg.config;

import com.example.StudentReg.StudentController;
import com.example.StudentReg.StudentLoader;
import com.example.StudentReg.StudentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
public class AppConfig {


    @Bean
    @Profile("init")
    public StudentLoader loader(@Value("${init.file:#{null}}") String path) {
        return new StudentLoader(path);
    }

    @Bean
    @Profile("!init")
    public StudentService defaultStudentService(ApplicationEventPublisher publisher) {
        return new StudentService(publisher);
    }

}


