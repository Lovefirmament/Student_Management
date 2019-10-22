package pers.ssm.mapper;

import java.util.List;

import pers.ssm.po.Student;

public interface StudentMapper {
      public List<Student> queryAllStudent();
      public Student queryStudentById(Integer id);
      public Student queryStudentByNo(String number);
      public void updateStudent(Student student);
      public void deleteStudentById(Integer id);
      public void insertStudent(Student student);
      public List<Student> queryStudentByPage(Integer pageStart, Integer pageSize);
      public int totalCount();
}
