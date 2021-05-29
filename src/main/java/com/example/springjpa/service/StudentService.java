package com.example.springjpa.service;

import com.example.springjpa.entry.Student;
import com.example.springjpa.jpa.StudentJpa;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService  {
    Logger log= LoggerFactory.getLogger(StudentService.class);
    public StudentService() {
        System.out.println("初始化StudentService");
    }

    @Autowired
    StudentJpa studentJpa;

    @Transactional
     public List<Student> query(Student student){
         Example example= Example.of(student);
         log.info("条件:{}",example);

       return studentJpa.findAll(example);
    }

    @Transactional
    public  void update(Student student){
       studentJpa.save(student);
    }

    @Transactional
    public  void delete(Integer id){
        log.info("条件:{}",id);
        studentJpa.deleteById(id);
    }



}
