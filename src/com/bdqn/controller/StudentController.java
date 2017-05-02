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
@RequestMapping("/") //ָ������������ռ��ǰ׺
public class StudentController {
	
	@Autowired//�Զ�װ��ҵ���ӿ�1
	private StudentService studentService;
	
	@Autowired//�Զ�װ��ҵ���ӿ�2
	private GradeService gradeService;
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}



	@RequestMapping("getAll.do")
	//��������ڷ���
	public String getAll(Pager pager,Model model){
		//���ղ���֮ǰ������web.xml�����õ�ת�������ͳһת�����
		model.addAttribute("list", studentService.getStudentByPager(pager));
		model.addAttribute("pager",pager);
		return "select";
	}
	
	@RequestMapping("toAdd.do")//���뵽����ҳ��
	//��������ڷ���
	public String toAdd(@ModelAttribute Student student,Model model){
		List<Grade> gradeList=gradeService.getAll();
		model.addAttribute("gradeList", gradeList);
		return "add";
		
	}
	
	@RequestMapping("doAdd.do")//�ύ���������ݿ�
	//���ĸ���ڷ���//(����ʹ��ModelAndView��ʽ�⡣������ʹ��Map��Model��ModelMap����ǰ̨ҳ�洴��)
	public String doAdd(@ModelAttribute Student student){
		int sid=studentService.addStudent(student);
		System.out.println("����ѧ���ɹ���ѧ���ǣ�"+sid);
		return "redirect:/getAll.do";
		
	}
	
	@RequestMapping("toUpdate/{sno}")//REST��񣬽��뵽����ҳ��
	//�������ڷ���
	public String toUpdate(@PathVariable int sno,Model model){
		//�õ��޸�ǰ������
		Student oldStudent=studentService.getStudentById(sno);
		//�õ��꼶����������Ϣ
		List<Grade> gradeList=gradeService.getAll();
		model.addAttribute("oldStudent", oldStudent);
		model.addAttribute("gradeList", gradeList);
		
		return "update";	
	}
	
	@RequestMapping("doUpdate.do")//�ύ�޸ĵ����ݿ�
	//��������ڷ���
	public String doUpdate(Student student){
		studentService.updateStudent(student);
		System.out.println("�޸ĳɹ�,ѧ��:"+student.getSno());
		return "redirect:/getAll.do";	
	}
	
	
	@RequestMapping("doDelete/{sno}")//�ύɾ�������ݿ�
	//��������ڷ���
	public String doDelete(@PathVariable int sno){
		studentService.deleteStudent(sno);
		System.out.println("ɾ���ɹ�,ѧ��:"+sno);
		return "redirect:/getAll.do";	
	}
	
	
	@RequestMapping("getAll2.do")
	//���߸���ڷ���
	public String getAll2(Student stu,Pager pager,Model model){
		//���ղ���֮ǰ������web.xml�����õ�ת�������ͳһת�����
		System.out.println("��ѯ����-->"+stu.getSname());
		model.addAttribute("list", studentService.getStudentByPager2(stu,pager));
		model.addAttribute("pager",pager);
		model.addAttribute("stu",stu);
		return "select2";
	}

}
