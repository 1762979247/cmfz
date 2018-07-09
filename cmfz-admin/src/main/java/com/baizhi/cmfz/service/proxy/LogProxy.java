package com.baizhi.cmfz.service.proxy;

import com.baizhi.cmfz.dao.LogDAO;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * @Description:    用于做系统日志的代理类
 * @Author zhy
 * @Date 2018-07-09 20:34
 */
@Aspect
@Transactional
public class LogProxy {

    @Autowired
    private LogDAO ld;
    /*@Autowired
    private HttpSession session;*/


    //定以切入(切入点方法)
    @Pointcut("execution(* com.baizhi.cmfz.service.impl.*.add*(..)) || execution(* com.baizhi.cmfz.service.impl.*.remove*(..)) || execution(* com.baizhi.cmfz.service.impl.*.modify*(..))")
    public void pc(){}

    //额外功能及组装切面
    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp){
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        Admin loginAdmin = (Admin) session.getAttribute("loginAdmin");
        String optName = loginAdmin.getUsername();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getSignature().getDeclaringType().getSimpleName();

        String action = "";
        if(methodName.contains("add")){
            action = "add";
        }else if(methodName.contains("remove")){
            action = "remove";
        }else if(methodName.contains("modify")){
            action = "modify";
        }else{
            action="there hava a error";
        }

        String resource = className.replace("Service","");

        Object[] args = pjp.getArgs();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < args.length; i++) {
            sb.append(args[i]+";");
        }
        String message = sb.toString();

        String result = "";
        Object obj = null;
        try {
            obj = pjp.proceed();
            result = "success";
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            result = "failure";
        }

        //将日志信息插入数据库
        Log log = new Log(null, optName, null, resource, action, message, result);
        Integer res = 0;
        try {
            res = ld.insertLog(log);
            if(res!=1){
                throw new RuntimeException("日志添加失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return obj;
    }


}
