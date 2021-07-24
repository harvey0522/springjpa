package com.example.springjpa;

import com.alibaba.fastjson.JSON;
import com.example.springjpa.entry.Student;
import com.example.springjpa.jpa.StudentJpa;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class SpringjpaApplicationTests {

	/*@Autowired
	StudentJpa studentJpa;*/
	/*@Resource
	private RocketMQTemplate rocketMQTemplate;*/

	/*@Test
	void contextLoads() {
		log.info("-------{}",rocketMQTemplate.toString());
		rocketMQTemplate.convertAndSend("tag1","hhhhhhhhhh");
	}*/

	/*@Test
	void test1(){

		List<Student> studentOptional=studentJpa.findAll();

		System.out.println(JSON.toJSON(studentOptional));
	}*/

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
				//studentJpa.saveAll(list);
			}

		System.out.println("------->>>>"+(System.currentTimeMillis()-time1));
		//System.out.println(JSON.toJSON(studentOptional));
	}


}
