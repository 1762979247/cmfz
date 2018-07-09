package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:    文章相关的DAO
 * @Author zhy
 * @Date 2018-07-08 21:19
 */
public interface ArticleDAO {

    /**
     * @Description  添加文章
     * @Author zhy
     * @Date 2018/7/8 21:20
     * @Param [atl]
     * @Return java.lang.Integer
     */
    public Integer insertArticle(Article atl);

    /**
     * @Description  分页查询文章
     * @Author zhy
     * @Date 2018/7/9 9:48
     * @Param [begin, offSet]
     * @Return java.util.List<com.baizhi.cmfz.entity.Article>
     */
    public List<Article> selectArticleByPage(@Param("begin") Integer begin, @Param("offSet") Integer offSet);

    /**
     * @Description  查询文章表中的总数据条数
     * @Author zhy
     * @Date 2018/7/9 11:11
     * @Param []
     * @Return java.lang.Integer
     */
    public Integer selectCount();
}
