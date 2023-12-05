package com.example.api.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIRECTORY="C:\\Users\\shrey\\Desktop\\springboot\\api\\src\\main\\resources\\static\\images";

    public boolean uploadFile(MultipartFile file){
        boolean flag=false;
        try{
            InputStream is=file.getInputStream();
            byte data[]=new byte[is.available()];
            is.read(data);
            FileOutputStream fos=new FileOutputStream(UPLOAD_DIRECTORY+ File.separator+file.getOriginalFilename());
            fos.write(data);
            fos.flush();
            fos.close();
            flag=true;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return flag;
    }

}
