package com.ijse.hellospring.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.hellospring.dto.stockitemDto;
import com.ijse.hellospring.entity.stock;
import com.ijse.hellospring.service.stockService;

@RestController
@CrossOrigin(origins = "*")
public class stockController {
    
    @Autowired
    private stockService stockService;

    @GetMapping("/stocks")
    public List<stock> getAllstocks() {
        return stockService.getAllstocks();
    }

    @GetMapping("/stocks/{id}")
    public stock getstockById(@PathVariable Long id) {
        return stockService.getstockById(id);
    }

    @PostMapping("/stocks")
    public stock createstock() {
        stock stock = new stock();

        stock.setTotalPrice(0.0);
        stock.setstockDate(LocalDateTime.now());
        stock.setstockeditems(null);

        return stockService.createstock(stock);
    }

    @PostMapping("/stocks/{id}/additem")
    public stock additemTostock(@PathVariable Long id, @RequestBody stockitemDto stockitemDto) {
        return stockService.additemTostock(id, stockitemDto.getitemId(), stockitemDto.getQuantity());
    }

    @DeleteMapping("/stocks/{stockId}/item/{itemId}")
    public stock removeitemFromstock(@PathVariable Long stockId, @PathVariable Long itemId) {
        return stockService.removeitemFromstock(stockId, itemId);
    }
}
