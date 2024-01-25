package com.merrach.userservice.repository;

import com.merrach.userservice.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<UserEntity,String> {
}
