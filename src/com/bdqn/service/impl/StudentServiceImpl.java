package com.bdqn.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.dao.StudentDao;
import com.bdqn.entity.Pager;
import com.bdqn.entity.Student;
import com.bdqn.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired//自动装配dao层
	private StudentDao studentDao;
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}



	@Override
	public List<Student> getAll() {
		return studentDao.getAllStudent();//调用dao层方法
	}



	@Override
	public List<Student> getStudentByPager(Pager pager) {
		int n=studentDao.getStudentByCount();
		pager.setTotalCounts(n);
		Map<String,Object> map=new HashMap<String,Object> ();
		//通过HashMap给sql映射文件传分页的信息
		map.put("pageOffset", (pager.getCurrPage()-1)*pager.getPageSize());//跳这多少行
		map.put("pageSize",pager.getPageSize());//每页大小
		return studentDao.getStudentByPager(map);
	}



	@Override
	public int addStudent(Student s) {
		studentDao.addStudent(s);
		return s.getSno();//返回主键学号
	}

	//根据id查询修改前的数据
	public Student getStudentById(int sno){
		return studentDao.getStudentById(sno);
	}
		
	//提交最新的学生信息
	public void updateStudent(Student s){
		studentDao.updateStudent(s);
	}
	
	//删除学生信息
	public void deleteStudent(int sno){
		studentDao.deleteStudent(sno);
	}
	
	
	@Override//带查询条件的分页
	public List<Student> getStudentByPager2(Student s,Pager pager) {
		int n=studentDao.getStudentByCount2(s);
		pager.setTotalCounts(n);
		Map<String,Object> map=new HashMap<String,Object> ();
		//通过HashMap给sql映射文件传分页的信息
		map.put("pageOffset", (pager.getCurrPage()-1)*pager.getPageSize());//跳这多少行
		map.put("pageSize",pager.getPageSize());//每页大小
		map.put("student",s);//查询条件
		return studentDao.getStudentByPager2(map);
	}
}
