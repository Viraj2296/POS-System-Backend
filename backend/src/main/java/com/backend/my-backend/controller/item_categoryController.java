package com.ijse.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.hellospring.entity.item_category;
import com.ijse.hellospring.service.item_categoryService;

@RestController
@CrossOrigin(origins = "*")
public class item_categoryController {
    
    @Autowired
    private item_categoryService item_categoryService;

    @GetMapping("/categories")
    public List<item_category> getAllCategories() {
        return item_categoryService.getAllCategories();
    }

    @GetMapping("/categories/{id}") 
    public item_category getitem_categoryById(@PathVariable Long id) {
        return item_categoryService.getitem_categoryById(id);
    }

    @PostMapping("/categories")
    public item_category createitem_category(@RequestBody item_category item_category) {
        return item_categoryService.createitem_category(item_category);
    }

}
