package com.example.LegalCrudApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LegalCrudApp.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
