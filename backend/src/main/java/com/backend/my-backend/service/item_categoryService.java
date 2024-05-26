package com.ijse.hellospring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.hellospring.entity.item_category;

@Service
public interface item_categoryService {
    List<item_category> getAllCategories();
    item_category getitem_categoryById(Long id);
    item_category createitem_category(item_category item_category);
}
