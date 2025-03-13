package com.Arthur.Request.Service.persistence.repository;

import com.Arthur.Request.Service.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
