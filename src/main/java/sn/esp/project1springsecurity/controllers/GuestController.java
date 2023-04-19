package sn.esp.project1springsecurity.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @GetMapping("/index")
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("Welcome to my page!");
    }
}
