import com.baizhi.cmfz.dao.LogDAO;
import com.baizhi.cmfz.entity.Log;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @Description:
 * @Author zhy
 * @Date 2018-07-09 20:19
 */
public class TestLogDAO {

    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        LogDAO ld = (LogDAO) ctx.getBean("logDAO");
        Log log = new Log(null,"zhy",null,"master","add","上师1","success");
        Integer integer = ld.insertLog(log);
        System.out.println(integer);

    }
}
