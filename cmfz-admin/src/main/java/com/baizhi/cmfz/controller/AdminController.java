package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.utils.VerifyCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2018/7/4.
 * @author zhy
 * @version 1.0
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes(value = {"code"})
public class AdminController {
    @Autowired
    private AdminService as;

    @RequestMapping(value = "/login", produces = "application/json;charset=utf-8")
    public String login(String username, String password, HttpServletResponse resp, String[] rm, String vcode, HttpSession session, Model model){
        String code = (String) session.getAttribute("code");
        if(!code.equalsIgnoreCase(vcode)){
            session.setAttribute("errorMsg","验证码错误，请重新输入！");
            return "redirect:/admin/goLogin";
        }
        try {
            Admin admin = as.searchAdminByName(username, password);
            if(rm!=null && "true".equals(rm[0])){
                Cookie c1 = new Cookie("uname", URLEncoder.encode(username, "utf-8"));
                Cookie c2 = new Cookie("pwd", URLEncoder.encode(password, "utf-8"));
                c1.setMaxAge(60*60*24*7);
                c2.setMaxAge(60*60*24*7);
                c1.setPath("/");
                c2.setPath("/");
                resp.addCookie(c1);
                resp.addCookie(c2);
            }

            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("errorMsg","用户名或密码错误，请重新登录！");
            return "redirect:/admin/goLogin";
        }
    }

    @RequestMapping("/getCode")
    public void getCode(Model model, HttpServletResponse resp) throws IOException {
        String code = VerifyCodeUtil.generateVerifyCode(4);
        model.addAttribute("code", code);
        BufferedImage image = VerifyCodeUtil.getImage(110, 35, code);
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }

    @RequestMapping("/goLogin")
    public String getCookie(HttpServletRequest req, Model model) throws UnsupportedEncodingException {
        Cookie[] cks = req.getCookies();
        for (Cookie ck : cks) {
           if(ck.getName().equals("uname")){
               model.addAttribute("uname", java.net.URLDecoder.decode(ck.getValue(),"utf-8"));
           } else if(ck.getName().equals("pwd")){
               model.addAttribute("pwd", java.net.URLDecoder.decode(ck.getValue(),"utf-8"));
           }

        }
        return "login";

    }
}
