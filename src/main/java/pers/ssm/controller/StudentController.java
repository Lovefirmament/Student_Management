package pers.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String updateStudentSubmit(Model model,Integer id,Student student) {
     	studentService.updateStudent(id,student);
     	return "redirect:/student/query.action";
	}
	@RequestMapping("/insert")
	public String insertStudent(Model model)
	{
		return "/jsp/student/insert.jsp";
	}
	@RequestMapping("/insertSubmit")
	public String insertStudent(Model model,Student student)
	{
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


