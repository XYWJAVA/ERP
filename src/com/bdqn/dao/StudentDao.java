package com.bdqn.dao;

import java.util.List;
import java.util.Map;

import com.bdqn.entity.Student;

public interface StudentDao {
	
	public void addStudent(Student s);
	
	//��ѯѧ����Ϣʹ�õ���
	public List<Student> getAllStudent();
	
	//��ѯѧ����Ϣʹ������
	public List<Student> getAllStudentWithGrade();
	
	
	
	
	
	//��ѯѧ����Ϣ�ļ�¼��
	public int getStudentByCount();
	
	//��ѯѧ����Ϣ����ҳ
	public List<Student> getStudentByPager(Map map);
	
	
	
	
	
	
	//����id��ѯ�޸�ǰ������
	public Student getStudentById(int sno);
	
	//�ύ���µ�ѧ����Ϣ
	public void updateStudent(Student s);
	
	//ɾ��ѧ����Ϣ
	public void deleteStudent(int sno);
	
	
	/******��������ҳ��ѯ*****/
	
	//��ѯѧ����Ϣ�ļ�¼��
	public int getStudentByCount2(Student s);
	
	//��ѯѧ����Ϣ����ҳ
	public List<Student> getStudentByPager2(Map map);
	
	/***********/

}
