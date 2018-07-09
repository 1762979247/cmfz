package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MasterDAO;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 上师的Service的实现
 * @Author zhy
 * @Date 2018-07-06 17:21
 */
@Service
@Transactional
public class MasterServiceImpl implements MasterService {

    @Autowired
    private MasterDAO md;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Map<String, Object> searchMasterByPage(Integer currentPage, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Master> masters = md.selectMasterByPage((currentPage - 1) * pageSize, pageSize);
            Integer count = md.selectCount();
            map.put("total", count);
            map.put("rows",masters);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return map;
    }

    @Override
    public List<Master> searchAll() {
        List<Master> masters = new ArrayList<Master>();
        try {
            masters = md.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return masters;
    }

    @Override
    public Map<String, Object> searchMasterByKeywords(Integer currentPage, Integer pageSize, String keywords) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Integer count = md.selectCountByKeywords(keywords);
            List<Master> masters = md.selectMasterByKeywords((currentPage - 1) * pageSize, pageSize, keywords);
            map.put("total", count);
            map.put("rows", masters);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return map;
    }

    @Override
    public void addMaster(Master master) {
        Integer res = 0;
        try {
            res = md.insertMaster(master);
            if(res!=1){
                throw new RuntimeException("添加失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addBatch(List<Master> masters) {
        Integer res = 0;
        try {
            res = md.batchInsert(masters);
            if(res!=masters.size()){
                throw new RuntimeException("添加失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modifyMaster(Master master) {
        Integer res = 0;
        try {
            res = md.updateMaster(master);
            if(res!=1){
                throw new RuntimeException("更改失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
