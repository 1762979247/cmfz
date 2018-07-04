package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.AdminDAO;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Administrator on 2018/7/4.
 * @author zhy
 * @version 1.0
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDAO ad;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Admin searchAdminByName(String username, String password) {
        try {
            Admin admin = ad.selectAdminByname(username);
            if (admin == null) {
                throw new RuntimeException("用户不存在");
            }else if(!admin.getPassword().equals(DigestUtils.md5Hex(password+admin.getSalt()))){
                throw new RuntimeException("密码错误！");
            }
            return admin;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}
