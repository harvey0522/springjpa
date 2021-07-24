package com.example.springjpa.web;

import com.example.springjpa.entry.Product;
import com.example.springjpa.entry.Student;

import com.example.springjpa.service.CommonService;
import com.example.springjpa.service.ProductService;
import com.example.springjpa.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StudentController {
    Logger log=LoggerFactory.getLogger(StudentController.class);
    @Resource
    private StudentService studentService2;

    @Autowired
    ProductService productService;

    @Autowired
    CommonService commonService;

    @RequestMapping("/query")
    @ResponseBody
    public List<Student> query(Student student){
        log.info("StudentController....query");
        return studentService2.query(student);
    }

    @RequestMapping("/querypro")
    public List<Product> querypro(Product product){
        log.info("StudentController....querypro");
        return productService.query(product);
    }

    @RequestMapping(value = "/add",method= {RequestMethod.POST,RequestMethod.GET})
    public String add(Student student){
        log.info("add--->>{}",student.toString());
        studentService2.update(student);
        return "ok";
    }

    @RequestMapping(value = "/addpro",method= {RequestMethod.POST,RequestMethod.GET})
    public String add(Product product){
        log.info("addpro---->>>>{}",product.toString());

        productService.update(product);
        return "redirect:/query";
    }

    @RequestMapping("/trans")
    public String delete(Integer id){
        log.info("StudentController....trans-->>,{},{}",id);
        commonService.deleteAll(id);
        return "ok";
    }

    @RequestMapping(value = "/mvcget",method =RequestMethod.GET )
    public String get(String param){
        log.info("00000.{}",param);
        return "2222..."+param;
    }

    @RequestMapping(value = "/mvcpost",method =RequestMethod.POST )
    public String mvcpost(String param){
        log.info("00000.{}",param);
        return "44444..."+param;
    }


}
