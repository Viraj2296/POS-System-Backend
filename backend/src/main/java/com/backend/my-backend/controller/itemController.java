package com.ijse.hellospring.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.hellospring.dto.itemDto;
import com.ijse.hellospring.entity.item_category;
import com.ijse.hellospring.entity.item;
import com.ijse.hellospring.service.item_categoryService;
import com.ijse.hellospring.service.itemService;

@RestController
@CrossOrigin(origins = "*")
public class itemController {
    
    @Autowired
    private itemService itemService;

    @Autowired
    private item_categoryService item_categoryService;

    @GetMapping("/items")
    public List<item> getAllitems() {
        return itemService.getAllitems();
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<item> getitemById(@PathVariable Long id) {
        item item = itemService.getitemById(id);

        if(item == null) {
            return ResponseEntity.status(404).build();
        } else {
            return ResponseEntity.status(200).body(item);
        }
    }

    @PostMapping("/items")
    public ResponseEntity<item> createitem(@RequestBody itemDto itemDto) {

        item item = new item();
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        item.setQuantity(itemDto.getQuantity());

        item_category item_category = item_categoryService.getitem_categoryById(itemDto.getitem_categoryId());
        item.setitem_category(item_category);

        item createitem = itemService.createitem(item);
        return ResponseEntity.status(201).body(createitem);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<item> updateitem(@PathVariable Long id, @RequestBody itemDto itemDto) {
        item item = new item();

        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        item.setQuantity(itemDto.getQuantity());

        item_category item_category = item_categoryService.getitem_categoryById(itemDto.getitem_categoryId());
        item.setitem_category(item_category);

        item updateitem = itemService.updateitem(id, item); //use the Service layer to update item

        if(updateitem == null) {
            return ResponseEntity.status(404).build();
        } else {
            return ResponseEntity.status(200).body(updateitem);
        }
    }
}
