package com.example.springjpa.service;

import com.example.springjpa.entry.Product;

import java.util.List;

public interface ProductInter {
    public List<Product> query(Product product);
    public  void update(Product product);
    public Product get(Integer id);
    public  int delete(Integer id);
}
