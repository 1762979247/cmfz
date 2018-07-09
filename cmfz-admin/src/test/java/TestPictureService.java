import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * @Description:
 * @Author zhy
 * @Date 2018-07-06 9:43
 */
public class TestPictureService {

    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        PictureService ps = (PictureService) ctx.getBean("pictureServiceImpl");

        new java.sql.Date(new java.util.Date().getTime());
        Picture pic = new Picture(UUID.randomUUID().toString(),"aaa.jpg",new java.util.Date(), "heheh", "未展示");
        ps.addPicture(pic);
    }
}
