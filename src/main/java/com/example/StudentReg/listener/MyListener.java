package com.example.StudentReg.listener;

import com.example.StudentReg.event.MyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener {

    @EventListener
    public void handleMyEvent(MyEvent event) {
        System.out.println("Event: " + event.getMessage());
    }
}
