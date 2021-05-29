package com.example.springjpa.jpa;

import com.example.springjpa.entry.Product;
import com.example.springjpa.entry.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductJpa extends JpaRepository<Product, Integer> {
}
