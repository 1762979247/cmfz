package com.baizhi.cmfz.controller;

import com.alibaba.fastjson.JSON;
import com.baizhi.cmfz.bo.AnalyzeData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:   统计分析的控制器
 * @Author zhy
 * @Date 2018-07-09 16:05
 */
@Controller
@RequestMapping("/analyze")
public class AnalyzeController {

    //提供女性App各省份使用数量数据的方法
    @RequestMapping("/getFemale")
    @ResponseBody
    public List<AnalyzeData> getFemale(){
        ArrayList<AnalyzeData> analyzeData = new ArrayList<>();
        analyzeData.add(new AnalyzeData("广东",666));
        analyzeData.add(new AnalyzeData("北京",111));
        analyzeData.add(new AnalyzeData("上海",222));
        analyzeData.add(new AnalyzeData("天津",333));
        analyzeData.add(new AnalyzeData("重庆",444));
        analyzeData.add(new AnalyzeData("河南",555));
        System.out.println(JSON.toJSONString(analyzeData));
        return analyzeData;
    }
}
