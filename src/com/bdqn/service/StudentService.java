package com.bdqn.service;

import java.util.List;

import com.bdqn.entity.Pager;
import com.bdqn.entity.Student;

public interface StudentService {
	
	public List<Student> getAll();
	
	//查询学生信息并分页
	public List<Student> getStudentByPager(Pager pager);
	
	//新增学生
	public int addStudent(Student s);

	//根据id查询修改前的数据
	public Student getStudentById(int sno);
		
	//提交最新的学生信息
	public void updateStudent(Student s);
	
	//删除学生信息
    public void deleteStudent(int sno);
    
    
    //查询学生信息带条件并分页
  	public List<Student> getStudentByPager2(Student s,Pager pager);
}
