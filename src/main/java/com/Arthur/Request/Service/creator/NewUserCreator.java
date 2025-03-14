package com.Arthur.Request.Service.creator;

import com.Arthur.Request.Service.enums.ProcessingStatus;
import com.Arthur.Request.Service.persistence.entity.User;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class NewUserCreator {

    public User create(@Nullable String name) {
        User user = new User();
        if (!StringUtils.hasText(name)) {
            name = "World";
        }

        user.setName(name);
        user.setProcessingStatus(ProcessingStatus.PROCESSING);
        user.setCreatedAt(OffsetDateTime.now(ZoneOffset.UTC));
        user.setUpdatedAt(OffsetDateTime.now(ZoneOffset.UTC));
        user.setCompletedAt(null);
        return user;
    }
}
