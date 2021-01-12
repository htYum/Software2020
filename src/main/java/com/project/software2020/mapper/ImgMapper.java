package com.project.software2020.mapper;

import com.project.software2020.pojo.ImgInfo;
import com.project.software2020.pojo.ReturnMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ImgMapper {
    /**
     * 上传图片
     * @param imgInfo
     */
    @Insert("insert into good_img (" +
            "img_name, " +
            "img_type, " +
            "img_size, " +
            "absolute_url, " +
            "relative_url, " +
            "img_md5," +
            "good_id," +
            "is_main) " +
            "values (" +
            "#{img_name}," +
            "#{img_type}," +
            "#{img_size}," +
            "#{absolute_url}," +
            "#{relative_url}," +
            "#{img_md5}," +
            "#{good_id}," +
            "#{is_main})")
    void uploadImg(ImgInfo imgInfo);

    /**
     * 按good_id从数据库查询imgInfo
     * @param good_id
     * @return
     */
    @Select("select * from good_img i where " +
            "i.good_id=#{good_id}")
    List<ImgInfo> getGoodImgsByGoodId(int good_id);

    /**
     * 获取商品主图信息
     * @param good_id
     * @return
     */
    @Select("select * from good_img where good_id=#{good_id} and is_main=1")
    ImgInfo getMainGoodImgByGoodId(int good_id);
}
