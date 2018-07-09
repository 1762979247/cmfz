package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDAO;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author zhy
 * @Date 2018-07-08 21:30
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleDAO ad;

    @Override
    public void addArticle(Article atl) {
        Integer res = 0;
        try {
            res = ad.insertArticle(atl);
            if(res!=1){
                throw new RuntimeException("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
