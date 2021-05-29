package com.example.springjpa;

import com.alibaba.fastjson.JSON;
import com.example.springjpa.entry.Student;
import com.example.springjpa.jpa.StudentJpa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringjpaApplicationTests {

	@Autowired
	StudentJpa studentJpa;
	@Test
	void contextLoads() {

	}

	@Test
	void test1(){

		List<Student> studentOptional=studentJpa.findAll();

		System.out.println(JSON.toJSON(studentOptional));
	}

	@Test
	void add(){

		//for(int a=1;a<100;a++)
		long time1=System.currentTimeMillis();

			for(int i=50000;i<250000;i++) {
				List list=new ArrayList();
				Student students = new Student();
				students.setId(i);
				students.setName("王柳" + i);
				students.setPhone(11 + i);
				students.setNumber("no" + i);
				list.add(students);
				studentJpa.saveAll(list);
			}

		System.out.println("------->>>>"+(System.currentTimeMillis()-time1));
		//System.out.println(JSON.toJSON(studentOptional));
	}


}
