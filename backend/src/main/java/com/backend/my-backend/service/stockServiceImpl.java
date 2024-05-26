package com.ijse.hellospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.hellospring.entity.stock;
import com.ijse.hellospring.entity.item;
import com.ijse.hellospring.repository.stockRepository;
import com.ijse.hellospring.repository.itemRepository;

@Service
public class stockServiceImpl implements stockService {
    
    @Autowired
    private stockRepository stockRepository;

    @Autowired
    private itemRepository itemRepository;

    @Override
    public List<stock> getAllstocks() {
        return stockRepository.findAll();
    }

    @Override
    public stock getstockById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public stock createstock(stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public stock additemTostock(Long stockId, Long itemId, int quantity) {
        stock stock = stockRepository.findById(stockId).orElse(null);

        if(stock == null) {
            return null;
        }

        item item = itemRepository.findById(itemId).orElse(null);

        if(item == null) {
            return null;
        }

        stock.getstockeditems().add(item);
        
        stock.setTotalPrice(stock.getTotalPrice() + item.getPrice() * quantity);

        return stockRepository.save(stock);

    }

    @Override
    public stock removeitemFromstock(Long stockId, Long itemId) {
        stock stock = stockRepository.findById(stockId).orElse(null);

        if(stock == null) {
            return null;
        }

        item item = itemRepository.findById(itemId).orElse(null);

        if(item == null) {
            return null;
        }

        stock.getstockeditems().remove(item);
        stock.setTotalPrice(stock.getTotalPrice() - item.getPrice());

        return stockRepository.save(stock);
    }
        
}
