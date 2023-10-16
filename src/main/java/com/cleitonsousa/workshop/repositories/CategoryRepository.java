package com.cleitonsousa.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleitonsousa.workshop.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
