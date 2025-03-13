package com.Arthur.Request.Service.controller;

import com.Arthur.Request.Service.persistence.entity.User;
import com.Arthur.Request.Service.persistence.repository.UserRepository;
import com.Arthur.Request.Service.restapi.RequestRequest;
import com.Arthur.Request.Service.restapi.RequestResponse;
import com.Arthur.Request.Service.service.RequestService;
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
public class RequestController {

    private final RequestService requestService;

    private final UserRepository userRepository;

    @Autowired
    public RequestController(RequestService requestService, UserRepository userRepository) {
        this.requestService = requestService;
        this.userRepository = userRepository;
    }

    @GetMapping("/v1/users")
    public SequencedCollection<User> request() {
        return userRepository.findAll();
    }

    @PostMapping("/v1/users")
    public ResponseEntity<RequestResponse> request(@Valid @RequestBody RequestRequest request) {
        RequestResponse response = requestService.process(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
