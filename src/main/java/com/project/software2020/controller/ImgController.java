package com.project.software2020.controller;

import com.project.software2020.pojo.ReturnMessage;
import com.project.software2020.service.impl.ImgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/img")
public class ImgController {
    @Autowired
    private ImgServiceImpl imgService;

    /**
     * 上传图片
     * @param multipartFile
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    public ReturnMessage uploadImg(@RequestParam("file")MultipartFile multipartFile, @RequestParam("good_id")String good_id, @RequestParam("is_main")int is_main) throws Exception{
        return imgService.uploadImg(multipartFile, good_id, is_main);
    }

    /**
     * 按good_id获取该商品的图片
     * @param good_id
     * @return
     */
    @GetMapping("/goodid/{good_id}")
    public ReturnMessage getGoodImgsByGoodId(@PathVariable("good_id")int good_id){
        return imgService.getGoodImgsByGoodId(good_id);
    }
}
