package com.example.springjpa.jpa;

import com.example.springjpa.entry.ConsignmentCommodity;
import com.example.springjpa.entry.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ConsignmentCommodityJpa extends JpaRepository<ConsignmentCommodity, Long> {
}
