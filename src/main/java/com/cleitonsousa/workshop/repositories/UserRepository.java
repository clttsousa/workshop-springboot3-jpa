package com.cleitonsousa.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleitonsousa.workshop.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
