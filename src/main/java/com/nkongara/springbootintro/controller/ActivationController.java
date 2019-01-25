package com.nkongara.springbootintro.controller;


import com.nkongara.springbootintro.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivationController {

    // notificationService
    private NotificationService notificationService;

    // Constructor based Injection
    @Autowired
    public ActivationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RequestMapping("/activation")
    public String activation() {
        return notificationService.toString();
    }
}
