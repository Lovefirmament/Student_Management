package pers.ssm.service;

import org.springframework.web.multipart.MultipartFile;
import pers.ssm.po.Student;
import pers.ssm.tool.utils.PageUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface StudentService {

	public List<Student> queryAllStudent();
	public Student queryStudentByNo(String number);
	public void inertStudent(Student student, MultipartFile pictureFile)throws IOException;
	public void updateStudent( Student student, MultipartFile pictureFile)throws IOException;
	public void deleteStudent(String number) throws IOException;
	public PageUtil<Student> queryStudentByPage(HttpServletRequest http);
}
