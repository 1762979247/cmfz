import com.baizhi.cmfz.dao.ArticleDAO;
import com.baizhi.cmfz.entity.Article;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description:
 * @Author zhy
 * @Date 2018-07-09 11:04
 */
public class TestArticleDAO {

    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ArticleDAO ad = (ArticleDAO) ctx.getBean("articleDAO");
        List<Article> articles = ad.selectArticleByPage(0, 5);
        for (Article article : articles) {
            System.out.println(article);
        }
        System.out.println(ad.selectCount());
    }
}
