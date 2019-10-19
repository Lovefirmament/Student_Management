package pers.ssm.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.multipart.MultipartFile;
import pers.ssm.mapper.StudentMapper;
import pers.ssm.po.Student;
import pers.ssm.po.utils.PageUtil;

public class StudentServiceImpl implements StudentService {

	final String pathname="E:/develop/upload/pic/";
	@Autowired
     private StudentMapper studentMapper;

	@Override
	public List<Student> queryAllStudent() {
		return studentMapper.queryAllStudent();
	}

	@Override
	public Student queryStudentByNo(Integer id) {
		return studentMapper.queryStudentByNo(id);
	}

	@Override
	public void inertStudent(Student student, MultipartFile pictureFile) throws IOException
	{
		String originalFilename =  pictureFile.getOriginalFilename();
		if(pictureFile!=null && originalFilename!=null && originalFilename.length()>0)
		{
			String newFileName = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
			File newFile = new File(pathname+newFileName);
			pictureFile.transferTo(newFile);
			student.setPic(newFileName);
		}
		studentMapper.insertStudent(student);
	}

	@Override
	public void updateStudent(Integer id, Student student,MultipartFile pictureFile) throws IOException
	{
		String originalFilename =  pictureFile.getOriginalFilename();
		if(pictureFile!=null && originalFilename!=null && originalFilename.length()>0)
		{
			String newFileName = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
			File newFile = new File(pathname+newFileName);
			pictureFile.transferTo(newFile);
			student.setPic(newFileName);
		}
		student.setId(id);
		studentMapper.updateStudent(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		Student student=studentMapper.queryStudentByNo(id);
		String deleteFileName=student.getPic();
		File deleteFile = new File(pathname+deleteFileName);
		deleteFile.delete();
		studentMapper.deleteStudentByNo(id);
	}

	@Override
	public PageUtil<Student> queryStudentByPage(HttpServletRequest http) {
		int pageCurrent=1;
		int pageSize=5;
		int pageCount=studentMapper.totalCount();
		
		PageUtil<Student> pageUtil=new PageUtil<Student>();
		if(http.getParameter("pageCurrent")!=null) {
	      pageCurrent=Integer.parseInt(http.getParameter("pageCurrent"));	
		}
		int pageNumber=pageCount%pageSize==0?pageCount/pageSize:pageCount/pageSize+1;
		int pageStart=(pageCurrent-1)*pageSize;
		int pageBefore=pageCurrent>1?pageCurrent-1:1;
		int pageAfter=pageCurrent<pageNumber?pageCurrent+1:pageNumber;
	    List<Student> list=studentMapper.queryStudentByPage(pageStart,pageSize);
	    pageUtil.setPageCurrent(pageCurrent);
        pageUtil.setPageCount(pageCount);
        pageUtil.setPageNumber(pageNumber);
        pageUtil.setPagesize(pageSize);
        pageUtil.setList(list);
        pageUtil.setPageBefore(pageBefore);
        pageUtil.setPageAfter(pageAfter);
        
		return pageUtil;
	}

}
