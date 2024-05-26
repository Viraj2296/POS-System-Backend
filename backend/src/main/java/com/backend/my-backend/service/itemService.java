package com.ijse.hellospring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.hellospring.entity.item;

@Service
public interface itemService {
    List<item> getAllitems();
    item getitemById(Long id);
    item createitem(item item);
    item updateitem(Long id, item item);
}
