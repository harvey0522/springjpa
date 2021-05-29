package com.example.springjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommonService {
    @Autowired
    ProductService productService;

    @Autowired
    StudentService studentService;


    @Transactional
    public void deleteAll(Integer id){
        productService.delete(id);
        int a=id/(id-10);

        studentService.delete(id);
    }
}
