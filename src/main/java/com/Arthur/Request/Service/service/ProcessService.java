package com.Arthur.Request.Service.service;

import com.Arthur.Request.Service.creator.NewUserCreator;
import com.Arthur.Request.Service.persistence.repository.UserRepository;
import com.Arthur.Request.Service.model.ProcessRequest;
import com.Arthur.Request.Service.model.ProcessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {

    private final UserRepository userRepository;

    private final NewUserCreator newUserCreator;

    @Autowired
    public ProcessService(UserRepository userRepository, NewUserCreator newUserCreator) {
        this.userRepository = userRepository;
        this.newUserCreator = newUserCreator;
    }

    public ProcessResponse process(ProcessRequest request) {
        userRepository.saveAndFlush(newUserCreator.create(request.getName()));
        return new ProcessResponse();
    }
}
