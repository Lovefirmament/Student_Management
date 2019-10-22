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

@Controller  //使用Controller标记的类是一个SpringMVC Controller对象
@RequestMapping("/admin") //窄化请求映射，便于对url进行管理
public class AdminController {
	@Autowired
	private StudentService studentService;

	@RequestMapping("/query")
	//HttpServletRequest获取客户端的请求
	public String queryStudent(Model model,HttpServletRequest http) {
		PageUtil<Student> pageUtil=studentService.queryStudentByPage(http);
		model.addAttribute("pageUtil", pageUtil);
		return "/jsp/admin/query.jsp";
	}
	@RequestMapping("/update")
	public String updateStudent(Model model,Integer id) {
		Student student=studentService.queryStudentById(id);
		model.addAttribute("student", student);
		return "/jsp/admin/update.jsp";
	}
	@RequestMapping("/updateSubmit")
	public String updateStudentSubmit(Model model, Integer id, Student student, MultipartFile pictureFile) throws IllegalStateException, IOException {
		studentService.updateStudent(id,student,pictureFile);
		return "redirect:/admin/query.action";
	}
	@RequestMapping("/insert")
	public String insertStudent(Model model)
	{
		return "/jsp/admin/insert.jsp";
	}
	@RequestMapping("/insertSubmit")
	//MultipartFile是用来接收前台传过来的文件
	public String insertStudent(Model model,Student student, MultipartFile pictureFile)throws IOException
	{
		studentService.inertStudent(student,pictureFile);
		return "redirect:/admin/query.action";
	}
	@RequestMapping("/delete")
	public String deleteStudent(Model model,Integer id)throws IOException
	{
		studentService.deleteStudent(id);
		return "redirect:/admin/query.action";
	}
}
