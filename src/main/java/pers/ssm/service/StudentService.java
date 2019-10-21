package pers.ssm.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.multipart.MultipartFile;
import pers.ssm.mapper.StudentMapper;
import pers.ssm.po.Student;
import pers.ssm.po.utils.PageUtil;

public interface StudentService {

	public List<Student> queryAllStudent();
	public Student queryStudentByNo(Integer id);
	public void inertStudent(Student student, MultipartFile pictureFile)throws IOException;
	public void updateStudent(Integer id, Student student,MultipartFile pictureFile)throws IOException;
	public void deleteStudent(Integer id) throws IOException;
	public PageUtil<Student> queryStudentByPage(HttpServletRequest http);
}
