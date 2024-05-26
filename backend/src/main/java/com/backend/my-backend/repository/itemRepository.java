package com.ijse.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.hellospring.entity.item;

@Repository
public interface itemRepository extends JpaRepository<item, Long> {
    
}
