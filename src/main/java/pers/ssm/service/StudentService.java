package pers.ssm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import pers.ssm.mapper.StudentMapper;
import pers.ssm.po.Student;
import pers.ssm.po.utils.PageUtil;

public interface StudentService {

	public List<Student> queryAllStudent();
	public Student queryStudentByNo(Integer id);
	public void inertStudent(Student student);
	public void updateStudent(Integer id, Student student);
	public void deleteStudent(Integer id);
	public PageUtil<Student> queryStudentByPage(HttpServletRequest http);
}
