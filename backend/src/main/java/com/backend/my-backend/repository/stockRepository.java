package com.ijse.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.hellospring.entity.stock;

@Repository
public interface stockRepository extends JpaRepository<stock, Long> {
    
}
