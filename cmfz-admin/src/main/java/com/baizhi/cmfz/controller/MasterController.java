package com.baizhi.cmfz.controller;

import com.alibaba.fastjson.JSON;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.apache.commons.io.FilenameUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description:  上师相关的控制器
 * @Author zhy
 * @Date 2018-07-06 19:12
 */
@Controller
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private MasterService ms;

    //分页查询上师
    @RequestMapping("/searchByPage")
    @ResponseBody
    public Map<String, Object> searchByPage(@RequestParam("page") Integer currentPage, @RequestParam("rows") Integer pageSize, String keywords,HttpSession session){
        if(keywords!=null){
            return ms.searchMasterByKeywords(currentPage, pageSize, keywords.trim());
        }else{
            return ms.searchMasterByPage(currentPage, pageSize);
        }
    }

    //导出
    @RequestMapping("/export")
    public String exportExcel(ModelMap map){
        //查询要导出的数据
        List<Master> masters = ms.searchAll();
        //定义要导出的类的类对象
        map.put(NormalExcelConstants.CLASS, Master.class);
        //定义导出后的Excel文件名
        map.put(NormalExcelConstants.FILE_NAME,"上师表");
        //定义导出参数(包含表头和sheet名)
        ExportParams ep = new ExportParams("上师表", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        //push导出参数
        map.put(NormalExcelConstants.PARAMS, ep);
        //定义要导出的数据
        map.put(NormalExcelConstants.DATA_LIST,masters);
        //提供固定的返回值
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }

    //导入
    @RequestMapping("importData")
    @ResponseBody
    public String importData(MultipartFile file, HttpSession session) {
        try {
            ImportParams params = new ImportParams();
            //表格标题（默认为0）,如果设置标题，就设为1
            params.setTitleRows(1);
            //表头
            params.setHeadRows(1);
            //是否保存上传到的Excel
            params.setNeedSave(false);
            /*String path = session.getServletContext().getRealPath("");
            System.out.println(path);
            File f = new File(path+"/excel"+file.getOriginalFilename());
            file.transferTo(f);*/
            List<Master> masters = ExcelImportUtil.importExcel(file.getInputStream(), Master.class, params);
            ms.addBatch(masters);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    //添加上师
    @RequestMapping("/add")
    @ResponseBody
    public String addMaster(MultipartFile photo, Master master, HttpSession session) {
        try {
            //上传文件
            String realPath = session.getServletContext().getRealPath("\\");
            String uploadPath = realPath.substring(0,realPath.lastIndexOf("\\", realPath.lastIndexOf("\\")-1))+"\\upload\\master";
            String uuidName = UUID.randomUUID().toString().replace("-", "");
            String suffix = FilenameUtils.getExtension(photo.getOriginalFilename());
            photo.transferTo(new File(uploadPath+"\\"+uuidName+"."+suffix));
            //相关信息加入数据库
            master.setMasterPhoto(uuidName+"."+suffix);
            ms.addMaster(master);

            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

    }

    //更改上师信息
    @RequestMapping("/modify")
    @ResponseBody
    public String modifyMaster(Master master){
        try {
            ms.modifyMaster(master);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    //查询所有上师，用于下拉列表的填充
    @RequestMapping("/searchAll")
    @ResponseBody
    public List<Master> searchAllMaster(){
        List<Master> masters = ms.searchAll();
        return masters;
    }



}
