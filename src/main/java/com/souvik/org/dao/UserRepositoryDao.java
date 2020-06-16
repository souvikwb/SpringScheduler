package com.souvik.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.souvik.org.model.User;

public interface UserRepositoryDao extends JpaRepository<User, Integer>{

}
