package com.ijse.hellospring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.hellospring.entity.stock;

@Service
public interface stockService {
    List<stock> getAllstocks();
    stock getstockById(Long id);
    stock createstock(stock stock);
    stock additemTostock(Long stockId, Long itemId, int quantity);
    stock removeitemFromstock(Long stockId, Long itemId);
}
