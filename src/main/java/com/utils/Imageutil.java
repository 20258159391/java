package com.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Imageutil {

    //文件存储路径
    //指定路径时必须指定文件的名称，否则无法访问
    private final static String SAVE_IMAGE_PATH="D:\\Program Files (x86)\\shtp_photoes\\";


    public static String getImageSuffix(MultipartFile myfile){
        String fileName=myfile.getOriginalFilename();//获取原文件名
        int index=fileName.indexOf(".");
        return fileName.substring(index,fileName.length());
    }

    public static String getNewFileName(String suffix){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(new Date());
        return format+ UUID.randomUUID()+suffix;
    }


    public static boolean saveImage(MultipartFile mfile,File file)  {
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try {
            mfile.transferTo(file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getNewImagePath(String name){
        return SAVE_IMAGE_PATH+name;
    }
}
