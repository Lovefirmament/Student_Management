package pers.ssm.tool.utils;

import org.springframework.web.multipart.MultipartFile;
import pers.ssm.po.Student;

import java.io.File;
import java.io.IOException;

public class PicUtil {
    private final String pathname="E:\\develop\\upload\\pic\\";
    public void  setPic(MultipartFile pictureFile, Student student)throws IOException {
        String originalFilename =  pictureFile.getOriginalFilename();
        if(pictureFile!=null && originalFilename!=null && originalFilename.length()>0)
        {
            String newFileName = student.getName()+student.getNumber()+"pic"+originalFilename.substring(originalFilename.lastIndexOf("."));
            File newFile = new File(pathname+newFileName);
            pictureFile.transferTo(newFile);
            student.setPic(newFileName);
        }
    }
    public void  deletePic(Student student)throws IOException {
        String deleteFileName = student.getPic();
        if (deleteFileName != null) {
            File deleteFile = new File(pathname + deleteFileName);
            deleteFile.delete();
        }
    }
}
