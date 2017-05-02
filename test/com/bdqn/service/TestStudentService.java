package com.bdqn.service;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bdqn.entity.Pager;
import com.bdqn.entity.Student;

public class TestStudentService {
	private ApplicationContext context=null;

	@Before
	public void setUp() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@After
	public void tearDown() throws Exception {
		context=null;
	}

	
	
	@Test
	public void testStudentByPager() {
		StudentService sbiz=(StudentService)context.getBean("studentService");
		Pager p=new Pager();
		p.setCurrPage(1);
		p.setPageSize(5);
		List<Student> list=sbiz.getStudentByPager(p);
		
		for (Student s : list) {
			System.out.println(s.getSno()+"\t"+s.getSname()+"\t"+s.getSpass()+s.getBirthdate()+"\t"
		    +s.getGrade().getGid()+"\t"+s.getGrade().getGname());
		}
	}
	
	@Test
	public void testStudentByPager2() {
		StudentService sbiz=(StudentService)context.getBean("studentService");
		Student stu=new Student();
		stu.setSname("уе");
		Pager p=new Pager();
		p.setCurrPage(1);
		p.setPageSize(5);
		List<Student> list=sbiz.getStudentByPager2(stu,p);
		
		for (Student s : list) {
			System.out.println(s.getSno()+"\t"+s.getSname()+"\t"+s.getSpass()+s.getBirthdate()+"\t"
		    +s.getGrade().getGid()+"\t"+s.getGrade().getGname());
		}
	}

}
