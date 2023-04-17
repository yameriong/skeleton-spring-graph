package com.hojun.sg.bus.repository;

import com.hojun.sg.bus.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{}
