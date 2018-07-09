package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PictureDAO;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 轮播图相关业务的实现类
 * @Author zhy
 * @Date 2018-07-05 19:41
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDAO pd;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Map<String, Object> searchPictureByPage(Integer currentPage, Integer pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Integer count = pd.selectCount();
            List<Picture> pictures = pd.selectAll((currentPage - 1) * pageSize, pageSize);
            map.put("total", count);
            map.put("rows", pictures);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return map;
    }

    @Override
    public void addPicture(Picture pic) {
        Integer res = 0;
        try {
            res = pd.insertPicture(pic);
            if(res!=1){
                throw new RuntimeException("添加失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
