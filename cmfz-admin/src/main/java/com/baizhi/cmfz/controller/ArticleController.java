package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.bo.RichText;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
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
import java.util.ArrayList;
import java.util.UUID;

/**
 * @Description:   文章相关的控制器
 * @Author zhy
 * @Date 2018-07-08 20:03
 */
//下载文章插图到服务器
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService as;


    @RequestMapping("/uploadPic")
    @ResponseBody
    public RichText uploadPic(@RequestParam("pics") MultipartFile[] pics, HttpSession session, HttpServletRequest req) throws IOException {

        RichText rt = new RichText();
        ArrayList<String> list = new ArrayList<>();
        try {
            String realPath = session.getServletContext().getRealPath("\\");
            String uploadPath = realPath.substring(0, realPath.lastIndexOf("\\", realPath.lastIndexOf("\\")-1))+"\\upload\\article";
            for (MultipartFile pic : pics) {
                String uuidName = UUID.randomUUID().toString().replace("-", "");
                pic.transferTo(new File(uploadPath+"\\"+uuidName+"."+ FilenameUtils.getExtension(pic.getOriginalFilename())));
                list.add(req.getContextPath()+"\\upload\\article\\"+uuidName+"."+ FilenameUtils.getExtension(pic.getOriginalFilename()));
            }
            rt.setErrno(0);
        } catch (IOException e) {
            e.printStackTrace();
            rt.setErrno(-1);
        }
        rt.setData(list);
        return rt;
    }

    //添加文章
    @RequestMapping("/add")
    @ResponseBody
    public String addArticle(Article arl){
        System.out.println(arl.getMaster().getMasterId()+"=======================");
        if("--请选择--".equals(arl.getMaster().getMasterId())){
            return "noMasterError";
        }
        if("on".equals(arl.getArticleStatus())){
            arl.setArticleStatus("上架中");
        }else{
            arl.setArticleStatus("已下架");
        }
        try {
            as.addArticle(arl);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


}


