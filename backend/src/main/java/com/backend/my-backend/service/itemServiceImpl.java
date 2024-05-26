package com.ijse.hellospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.hellospring.entity.item;
import com.ijse.hellospring.repository.itemRepository;

@Service
public class itemServiceImpl implements itemService {

    @Autowired
    private itemRepository itemRepository;

    @Override
    public List<item> getAllitems() {
        return itemRepository.findAll();
    }

    @Override
    public item getitemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public item createitem(item item) {
        return itemRepository.save(item);
    }

    @Override
    public item updateitem(Long id, item item) {
        item existitem = itemRepository.findById(id).orElse(null);

        if(existitem == null) {
            return null;
        }

        existitem.setName(item.getName());
        existitem.setPrice(item.getPrice());
        existitem.setQuantity(item.getQuantity());
        existitem.setitem_category(item.getitem_category());

        return itemRepository.save(existitem);
    }
}
