package pers.ssm.mapper;

import org.apache.ibatis.annotations.Mapper;
import pers.ssm.po.Student;

import java.util.List;

@Mapper
public interface StudentMapper {
      public List<Student> queryAllStudent();
      public Student queryStudentByNo(String number);
      public void updateStudent(Student student);
      public void deleteStudentByNo(String number);
      public void insertStudent(Student student);
      public List<Student> queryStudentByPage(Integer pageStart, Integer pageSize);
      public int totalCount();
}
