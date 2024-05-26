package com.ijse.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.hellospring.entity.item_category;

@Repository
public interface item_categoryRepository extends JpaRepository<item_category, Long> {
    
}
