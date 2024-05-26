package com.ijse.hellospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.hellospring.entity.item_category;
import com.ijse.hellospring.repository.item_categoryRepository;

@Service
public class item_categoryServiceImpl implements item_categoryService{
    
    @Autowired
    private item_categoryRepository item_categoryRepository;

    @Override
    public List<item_category> getAllCategories() {
        return item_categoryRepository.findAll();
    }

    @Override
    public item_category getitem_categoryById(Long id) {
        return item_categoryRepository.findById(id).orElse(null);
    }

    @Override
    public item_category createitem_category(item_category item_category) {
        return item_categoryRepository.save(item_category);
    }

}
