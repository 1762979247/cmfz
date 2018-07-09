import com.baizhi.cmfz.dao.MasterDAO;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author zhy
 * @Date 2018-07-06 17:32
 */
public class TestMasterDAO {

   /* @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MasterDAO md = (MasterDAO) ctx.getBean("masterDAO");
        md.selectMasterByPage();
    }*/

   @Test
    public void test1(){
       ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
       MasterDAO md = (MasterDAO) ctx.getBean("masterDAO");
       Integer count = md.selectCountByKeywords("仁波切");
       List<Master> masters = md.selectMasterByKeywords(0, 5, "仁波切");
       for (Master master : masters) {
           System.out.println(master);

       }
       System.out.println(count);

    }
}
