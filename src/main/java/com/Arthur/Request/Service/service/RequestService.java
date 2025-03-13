package com.Arthur.Request.Service.service;

import com.Arthur.Request.Service.creator.NewUserCreator;
import com.Arthur.Request.Service.persistence.entity.User;
import com.Arthur.Request.Service.persistence.repository.UserRepository;
import com.Arthur.Request.Service.restapi.RequestRequest;
import com.Arthur.Request.Service.restapi.RequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RequestService {

    private final UserRepository userRepository;

    private final NewUserCreator newUserCreator;

    @Autowired
    public RequestService(UserRepository userRepository, NewUserCreator newUserCreator) {
        this.userRepository = userRepository;
        this.newUserCreator = newUserCreator;
    }

    public RequestResponse process(RequestRequest request) {
        userRepository.saveAndFlush(newUserCreator.create(Optional.ofNullable(request.getName())));
        return new RequestResponse();
    }
}
