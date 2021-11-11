package com.example.springjpa.web;


import com.example.springjpa.entry.Product;
import com.example.springjpa.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Slf4j
public class ProductController{

    //@Qualifier("productService")
    @Autowired
    ProductService productService2;

    @RequestMapping("/query/pro")
    public List<Product> query(Product product){
        return productService2.query(product);
    }

    @RequestMapping("/query/pro/{id}")
    public Product query(@PathVariable(value = "id") Integer id){
        return productService2.get(id);
    }
}
