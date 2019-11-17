package pers.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pers.ssm.mapper.StudentMapper;
import pers.ssm.po.Student;
import pers.ssm.tool.utils.PageUtil;
import pers.ssm.tool.utils.PicUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
     private StudentMapper studentMapper;

	@Override
	public List<Student> queryAllStudent() {
		return studentMapper.queryAllStudent();
	}


	@Override
	public Student queryStudentByNo(String number) {
		return studentMapper.queryStudentByNo(number);
	}

	@Override
	public void inertStudent(Student student, MultipartFile pictureFile) throws IOException
	{
		if(pictureFile!=null)
		{
			PicUtil picUtil = new PicUtil();
			picUtil.setPic(pictureFile, student);
		}
		studentMapper.insertStudent(student);
	}

	@Override
	public void updateStudent(Student student, MultipartFile pictureFile) throws IOException
	{
		if(pictureFile!=null) {
			PicUtil picUtil = new PicUtil();
			picUtil.setPic(pictureFile, student);
		}
		studentMapper.updateStudent(student);
	}

	@Override
	public void deleteStudent(String number) throws IOException{
		// TODO Auto-generated method stub
		Student student=studentMapper.queryStudentByNo(number);
		PicUtil picUtil=new PicUtil();
		picUtil.deletePic(student);
		studentMapper.deleteStudentByNo(number);
	}

	@Override
	public PageUtil<Student> queryStudentByPage(HttpServletRequest http) {
		int pageCurrent=1;
		int pageSize=5;    //一页的条数
		int pageCount=studentMapper.totalCount(); //总数据条数
		
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
