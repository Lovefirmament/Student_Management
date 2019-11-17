package pers.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pers.ssm.po.Student;
import pers.ssm.po.StudentVo;
import pers.ssm.tool.utils.PageUtil;
import pers.ssm.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    @ResponseBody
    public StudentVo queryStudentpage(HttpSession session, HttpServletRequest http) {
        String name=(String)session.getAttribute("name");
        Student student=studentService.queryStudentByNo(name);
        StudentVo studentVo=new StudentVo();
        studentVo.setStudent(student);
        studentVo.setUserId(name);
        return studentVo;
    }
    @RequestMapping(value ="/studentdetail/{number}",method = RequestMethod.GET)
    @ResponseBody
    public StudentVo updateStudent( HttpSession session,@PathVariable String number) {
        String name=(String)session.getAttribute("name");
        Student student=studentService.queryStudentByNo(number);
        StudentVo studentVo=new StudentVo();
        studentVo.setStudent(student);
        studentVo.setUserId(name);
        return studentVo;
    }
    @RequestMapping("/updatesubmit")
    public String updateStudentSubmit(Student student, MultipartFile pictureFile) throws IllegalStateException, IOException {
        studentService.updateStudent(student,pictureFile);
        return "redirect:/publish/user/query.html";
    }

}
