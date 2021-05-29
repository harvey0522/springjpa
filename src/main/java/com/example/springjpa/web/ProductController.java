package com.example.springjpa.web;


import com.example.springjpa.entry.Product;
import com.example.springjpa.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController{
    Logger log= LoggerFactory.getLogger(ProductController.class);
    //@Qualifier("productService")
    @Autowired
    ProductService productService2;

    @RequestMapping("/query/pro")
    public ModelAndView query(Product product){
        log.info(">>>>>>>>{}",productService2.query(product));
        ModelAndView model=new ModelAndView();
        model.addObject("hello","world");
        return model;
    }
}
