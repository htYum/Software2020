package com.project.software2020.service.impl;

import com.project.software2020.mapper.ImgMapper;
import com.project.software2020.pojo.ImgInfo;
import com.project.software2020.pojo.ReturnMessage;
import com.project.software2020.service.ImgService;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class ImgServiceImpl implements ImgService {
//    @Value("${upload.file.url}")
//    private String uploadUrl;
//    @Value("webdav")
//    private String uploadUserName;
//    @Value("webdav")
//    private String uploadPassword;
    @Autowired
    private ImgMapper imgMapper;

    @Override
    public ReturnMessage uploadImg(MultipartFile multipartFile, String good_id, int is_main) {
        ReturnMessage result = new ReturnMessage();
        result.setCode(0);
        result.setData(null);

        long size = multipartFile.getSize();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String fileMd5 = "";
        String fileExt = "";
        String fileName = multipartFile.getOriginalFilename();

        if(fileName.contains(".")){
            fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        }
        try {
            Random random = new Random();
            fileMd5 = md5File(good_id + "_" + date + random.nextInt());
        }
        catch (Exception e){
            result.setCode(0);
            result.setMessage(e.getMessage());
            e.printStackTrace();
            return result;
        }
        fileName = fileMd5;

        fileName += "." + fileExt;

        ApplicationHome home = new ApplicationHome(getClass());
        File jarDirFile = home.getSource().getParentFile();
        String jarDir = jarDirFile.toString().replace("\\", "/");
        String saveUrl = "/img/";

        try {
            File dir = new File(jarDir + saveUrl);
            if(!dir.exists()){
                dir.mkdir();
            }
            saveUrl += good_id + "/";
            dir = new File(jarDir + saveUrl);
            if(!dir.exists()){
                dir.mkdir();
            }
            saveUrl += date + "/";
            dir = new File(jarDir + saveUrl);
            if(!dir.exists()){
                dir.mkdir();
            }
            File saveFile = new File( jarDir + saveUrl + fileName);
            multipartFile.transferTo(saveFile);
        }
        catch (Exception e){
            result.setCode(0);
            result.setMessage(e.getMessage());
            e.printStackTrace();
            return result;
        }

        ImgInfo imgInfo = new ImgInfo();
        imgInfo.setImg_name(fileName);
        imgInfo.setImg_md5(fileMd5);
        imgInfo.setImg_size(String.valueOf(size));
        imgInfo.setImg_type(fileExt);
        imgInfo.setRelative_url(saveUrl);
        String location = jarDir + saveUrl;
        imgInfo.setAbsolute_url(location);
        imgInfo.setGood_id(good_id);
        imgInfo.setIs_main(is_main);

        try {
            imgMapper.uploadImg(imgInfo);
            result.setCode(1);
            result.setMessage("上传成功");
            result.setData(imgInfo);
        }
        catch (Exception e){
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    private String md5File(String nameDate) throws Exception{
        try{
            return DigestUtils.md5DigestAsHex(nameDate.getBytes());
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public ReturnMessage getGoodImgsByGoodId(int good_id){
        ReturnMessage result = new ReturnMessage();
        result.setCode(0);
        result.setData(null);

        List<ImgInfo> imgs;

        try {
            imgs = imgMapper.getGoodImgsByGoodId(good_id);
            result.setCode(1);
            result.setMessage("获取成功");
            result.setData(imgs);
            return result;
        }
        catch (Exception e){
            result.setCode(0);
            result.setMessage(e.getMessage());
            result.setData(null);
            return result;
        }
    }
}
