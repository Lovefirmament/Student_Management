package pers.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartFile;
import pers.ssm.po.Student;
import pers.ssm.po.utils.PageUtil;
import pers.ssm.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;


	@RequestMapping("/query")
	public String queryStudent(Model model,HttpServletRequest http) {
		PageUtil<Student> pageUtil=studentService.queryStudentByPage(http);
		model.addAttribute("pageUtil", pageUtil);
		return "/jsp/student/query.jsp";
	}
	@RequestMapping("/update")
	public String updateStudent(Model model,Integer id) {
		Student student=studentService.queryStudentByNo(id);
		model.addAttribute("student", student);
		return "/jsp/student/update.jsp";
	}
	@RequestMapping("/updateSubmit")
	public String updateStudentSubmit(Model model, Integer id, Student student, MultipartFile pictureFile) throws IllegalStateException, IOException {
		String originalFilename =  pictureFile.getOriginalFilename();
		if(pictureFile!=null && originalFilename!=null && originalFilename.length()>0)
		{
			String newFileName = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
			File newFile = new File("E:/develop/upload/pic/"+newFileName);
			pictureFile.transferTo(newFile);
			student.setPic(newFileName);
		}
		studentService.updateStudent(id,student);
		return "redirect:/student/query.action";
	}
	@RequestMapping("/insert")
	public String insertStudent(Model model)
	{
		return "/jsp/student/insert.jsp";
	}
	@RequestMapping("/insertSubmit")
	public String insertStudent(Model model,Student student, MultipartFile pictureFile)throws IllegalStateException, IOException
	{
		String originalFilename =  pictureFile.getOriginalFilename();
		if(pictureFile!=null && originalFilename!=null && originalFilename.length()>0)
		{
			String newFileName = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
			File newFile = new File("E:/develop/upload/pic/"+newFileName);
			pictureFile.transferTo(newFile);
			student.setPic(newFileName);
		}
		studentService.inertStudent(student);
		return "redirect:/student/query.action";
	}
	@RequestMapping("/delete")
	public String deleteStudent(Model model,Integer id)
	{
		studentService.deleteStudent(id);
		return "redirect:/student/query.action";
	}
}
