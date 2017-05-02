package com.bdqn.dao;

import java.util.List;
import java.util.Map;

import com.bdqn.entity.Student;

public interface StudentDao {
	
	public void addStudent(Student s);
	
	//查询学生信息使用单表
	public List<Student> getAllStudent();
	
	//查询学生信息使用两表
	public List<Student> getAllStudentWithGrade();
	
	
	
	
	
	//查询学生信息的记录数
	public int getStudentByCount();
	
	//查询学生信息并分页
	public List<Student> getStudentByPager(Map map);
	
	
	
	
	
	
	//根据id查询修改前的数据
	public Student getStudentById(int sno);
	
	//提交最新的学生信息
	public void updateStudent(Student s);
	
	//删除学生信息
	public void deleteStudent(int sno);
	
	
	/******按条件分页查询*****/
	
	//查询学生信息的记录数
	public int getStudentByCount2(Student s);
	
	//查询学生信息并分页
	public List<Student> getStudentByPager2(Map map);
	
	/***********/

}
