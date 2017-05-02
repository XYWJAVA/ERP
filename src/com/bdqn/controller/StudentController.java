package com.bdqn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdqn.entity.Grade;
import com.bdqn.entity.Pager;
import com.bdqn.entity.Student;
import com.bdqn.service.GradeService;
import com.bdqn.service.StudentService;

@Controller("test")
@RequestMapping("/") //指定该类的命名空间的前缀
public class StudentController {
	
	@Autowired//自动装配业务层接口1
	private StudentService studentService;
	
	@Autowired//自动装配业务层接口2
	private GradeService gradeService;
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}



	@RequestMapping("getAll.do")
	//第三个入口方法
	public String getAll(Pager pager,Model model){
		//接收参数之前，已由web.xml中配置的转码过滤器统一转码完毕
		model.addAttribute("list", studentService.getStudentByPager(pager));
		model.addAttribute("pager",pager);
		return "select";
	}
	
	@RequestMapping("toAdd.do")//进入到新增页面
	//第三个入口方法
	public String toAdd(@ModelAttribute Student student,Model model){
		List<Grade> gradeList=gradeService.getAll();
		model.addAttribute("gradeList", gradeList);
		return "add";
		
	}
	
	@RequestMapping("doAdd.do")//提交新增到数据库
	//第四个入口方法//(除了使用ModelAndView方式外。还可以使用Map、Model和ModelMap来向前台页面创造)
	public String doAdd(@ModelAttribute Student student){
		int sid=studentService.addStudent(student);
		System.out.println("新增学生成功，学号是："+sid);
		return "redirect:/getAll.do";
		
	}
	
	@RequestMapping("toUpdate/{sno}")//REST风格，进入到新增页面
	//第五个入口方法
	public String toUpdate(@PathVariable int sno,Model model){
		//拿到修改前的数据
		Student oldStudent=studentService.getStudentById(sno);
		//拿到年级的下拉框信息
		List<Grade> gradeList=gradeService.getAll();
		model.addAttribute("oldStudent", oldStudent);
		model.addAttribute("gradeList", gradeList);
		
		return "update";	
	}
	
	@RequestMapping("doUpdate.do")//提交修改到数据库
	//第六个入口方法
	public String doUpdate(Student student){
		studentService.updateStudent(student);
		System.out.println("修改成功,学号:"+student.getSno());
		return "redirect:/getAll.do";	
	}
	
	
	@RequestMapping("doDelete/{sno}")//提交删除到数据库
	//第六个入口方法
	public String doDelete(@PathVariable int sno){
		studentService.deleteStudent(sno);
		System.out.println("删除成功,学号:"+sno);
		return "redirect:/getAll.do";	
	}
	
	
	@RequestMapping("getAll2.do")
	//第七个入口方法
	public String getAll2(Student stu,Pager pager,Model model){
		//接收参数之前，已由web.xml中配置的转码过滤器统一转码完毕
		System.out.println("查询条件-->"+stu.getSname());
		model.addAttribute("list", studentService.getStudentByPager2(stu,pager));
		model.addAttribute("pager",pager);
		model.addAttribute("stu",stu);
		return "select2";
	}

}
