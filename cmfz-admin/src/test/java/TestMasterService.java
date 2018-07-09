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
public class TestMasterService {

    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MasterService ms = (MasterService) ctx.getBean("masterServiceImpl");
        Map<String, Object> map = ms.searchMasterByPage(1, 5);
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry);
        }
    }

    @Test
    public void test2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MasterService ms = (MasterService) ctx.getBean("masterServiceImpl");
        List<Master> masters = ms.searchAll();
        for (Master master : masters) {
            System.out.println(master);
        }
    }

    @Test
    public void test3(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MasterService ms = (MasterService) ctx.getBean("masterServiceImpl");
        Map<String, Object> masters = ms.searchMasterByKeywords(1, 5, "仁波切");
        for (String s : masters.keySet()) {
            System.out.println(s);
            System.out.println(masters.get(s));

        }
    }
}
