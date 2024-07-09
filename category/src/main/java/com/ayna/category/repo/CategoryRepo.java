package com.ayna.category.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayna.category.entity.Category;


@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>{

}

