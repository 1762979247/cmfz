import com.baizhi.cmfz.dao.AdminDAO;
import com.baizhi.cmfz.dao.MenuDAO;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.utils.EncrypteUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 * @author zhy
 */
public class TestDAO {

    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminDAO ad = (AdminDAO) ctx.getBean("adminDAO");
        Admin admin = ad.selectAdminByname("zhy");
        System.out.println(admin);
    }
    @Test
    public void add(){
        String salt = EncrypteUtils.getSalt(6);
        System.out.println(salt);
        String s = DigestUtils.md5Hex("111222" + salt);
        System.out.println(s);
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuDAO md = (MenuDAO) ctx.getBean("menuDAO");
        System.out.println(md);
        List<Menu> menus = md.selectAllMenu();
        for (Menu menu : menus) {
            System.out.println(menu);

        }
    }

}
