package pers.ssm.po;

import pers.ssm.tool.utils.PageUtil;

import java.util.List;

public class StudentVo {
    private String userId;
    private Student student;
    private List<Student> studentList;
    private PageUtil<Student> pageStudentList;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public PageUtil<Student> getPageStudentList() {
        return pageStudentList;
    }

    public void setPageStudentList(PageUtil<Student> pageStudentList) {
        this.pageStudentList = pageStudentList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
