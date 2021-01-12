package com.project.software2020.service;

import com.project.software2020.pojo.ReturnMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImgService {
    ReturnMessage uploadImg(MultipartFile multipartFile, String good_id, int is_main);
    ReturnMessage getGoodImgsByGoodId(int good_id);
}
