package com.bdqn.dao;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bdqn.entity.Grade;
import com.bdqn.entity.Student;

public class TestStudentDao {
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
	public void testAll() {
		StudentDao sdao=(StudentDao)context.getBean("studentDao");
		List<Student> list=sdao.getAllStudent();
		
		for (Student s : list) {
			System.out.println(s.getSno()+"\t"+s.getSname()+"\t"+s.getSpass());
		}
		
		System.out.println(sdao);
	}
	
	@Test
	public void testAll2() {
		StudentDao sdao=(StudentDao)context.getBean("studentDao");
		List<Student> list=sdao.getAllStudentWithGrade();
		
		for (Student s : list) {
			System.out.println(s.getSno()+"\t"+s.getSname()+"\t"+s.getSpass()+"\t"
		    +s.getGrade().getGid()+"\t"+s.getGrade().getGname());
		}
		
		System.out.println(sdao);
	}
	
	@Test
	public void testAdd() {
		StudentDao sdao=(StudentDao)context.getBean("studentDao");
		Student s=new Student();
		s.setSname("张三3");
		s.setSpass("888");
		s.setBirthdate(new Date());
		Grade g=new Grade();
		g.setGid(3);
		s.setGrade(g);
		
		sdao.addStudent(s);
		
		System.out.println("新增成功,主键是:"+s.getSno());
	}
	
	
	@Test
	public void testUpdate() {
		StudentDao sdao=(StudentDao)context.getBean("studentDao");
		Student s=sdao.getStudentById(8);
		s.setSname("李四");
		sdao.updateStudent(s);
		System.out.println("修改成功");
	}
	
	
}
