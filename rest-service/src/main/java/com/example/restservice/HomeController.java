package com.example.restservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @PostMapping("/v1/packetone")
    public String createPacket(@RequestBody Enrollment enrollment){
        System.out.println("Creating packet using enrollment = "+enrollment);
        return "OK";
    }
}
