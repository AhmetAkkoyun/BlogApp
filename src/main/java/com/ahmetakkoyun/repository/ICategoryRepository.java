package com.ahmetakkoyun.repository;

import com.ahmetakkoyun.repository.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);
}
