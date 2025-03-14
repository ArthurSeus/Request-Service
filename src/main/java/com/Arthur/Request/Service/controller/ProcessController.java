package com.Arthur.Request.Service.controller;

import com.Arthur.Request.Service.persistence.entity.User;
import com.Arthur.Request.Service.persistence.repository.UserRepository;
import com.Arthur.Request.Service.model.ProcessRequest;
import com.Arthur.Request.Service.model.ProcessResponse;
import com.Arthur.Request.Service.service.ProcessService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.SequencedCollection;

@RestController
public class ProcessController {

    private final ProcessService processService;

    private final UserRepository userRepository;

    @Autowired
    public ProcessController(ProcessService processService, UserRepository userRepository) {
        this.processService = processService;
        this.userRepository = userRepository;
    }

    @GetMapping("/v1/users")
    public SequencedCollection<User> request() {
        return userRepository.findAll();
    }

    @PostMapping("/v1/users")
    public ResponseEntity<ProcessResponse> request(@Valid @RequestBody ProcessRequest request) {
        ProcessResponse response = processService.process(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
