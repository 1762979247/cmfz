package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @Description: 轮播图相关的控制器
 * @Author zhy
 * @Date 2018-07-05 19:47
 */
@Controller
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService ps;

    @RequestMapping("/showPicture")
    @ResponseBody
    public Map<String, Object> showPicture(@RequestParam("page") Integer currentPage, @RequestParam("rows") Integer pageSize){
        return ps.searchPictureByPage(currentPage, pageSize);
    }


    @RequestMapping("/add")
    @ResponseBody
    public String addPicture(String desc, String status, MultipartFile pic, HttpSession session, HttpServletRequest req){
        try {
            //上传文件
            String realPath = session.getServletContext().getRealPath("\\");
            String uploadPath = realPath.substring(0, realPath.lastIndexOf("\\", realPath.lastIndexOf("\\")-1))+"\\upload\\lunbo";
            String uuidName = UUID.randomUUID().toString().replace("-", "");
            String suffix = FilenameUtils.getExtension(pic.getOriginalFilename());
            pic.transferTo(new File(uploadPath+"\\"+uuidName+"."+suffix));

            //相关信息加入数据库
            Picture p = new Picture();
            String sta = "";
            if("yes".equals(status)){
                sta = "展示中";
            }else{
                sta = "未展示";
            }
            p.setPictureDesc(desc);
            p.setPictureStatus(sta);
            p.setPicturePath(uuidName+"."+suffix);
            ps.addPicture(p);

            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }


}
