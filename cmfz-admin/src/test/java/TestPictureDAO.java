import com.baizhi.cmfz.dao.PictureDAO;
import com.baizhi.cmfz.entity.Picture;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description:
 * @Author zhy
 * @Date 2018-07-05 19:28
 */
public class TestPictureDAO {
    
    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        PictureDAO pd = (PictureDAO) ctx.getBean("pictureDAO");
        List<Picture> pictures = pd.selectAll(5, 5);
        for (Picture picture : pictures) {
            System.out.println(picture);
        }
        System.out.println(pd.selectCount());
    }
}
