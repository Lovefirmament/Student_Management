package pers.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import pers.ssm.po.Student;
import pers.ssm.po.utils.PageUtil;
import pers.ssm.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/query")
    //HttpServletRequest获取客户端的请求
    public String queryStudent(Model model, HttpSession session) {
        String number=(String)session.getAttribute("name");
        Student student=studentService.queryStudentByNo(number);
        model.addAttribute("student", student);
        return "/jsp/student/query.jsp";
    }
    @RequestMapping("/update")
    public String updateStudent(Model model,Integer id) {
        Student student=studentService.queryStudentById(id);
        model.addAttribute("student", student);
        return "/jsp/student/update.jsp";
    }
    @RequestMapping("/updateSubmit")
    public String updateStudentSubmit(Model model, Integer id, Student student, MultipartFile pictureFile) throws IllegalStateException, IOException {
        studentService.updateStudent(id,student,pictureFile);
        return "redirect:/student/query.action";
    }
}
