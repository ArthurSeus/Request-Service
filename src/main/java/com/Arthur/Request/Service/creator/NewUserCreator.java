package com.Arthur.Request.Service.creator;

import com.Arthur.Request.Service.enums.ProcessingStatus;
import com.Arthur.Request.Service.persistence.entity.User;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class NewUserCreator {

    public User create(Optional<String> name) {
        User user = new User();

        if (name.isPresent()) {
            user.setName(name.get());
        }
        else {
            user.setName("World");
        }
        user.setProcessingStatus(ProcessingStatus.PROCESSING);
        user.setCreatedAt(OffsetDateTime.now(ZoneOffset.UTC));
        user.setUpdatedAt(OffsetDateTime.now(ZoneOffset.UTC));
        user.setCompletedAt(null);
        return user;
    }
}
