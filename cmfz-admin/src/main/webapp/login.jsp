<%--
  Created by IntelliJ IDEA.
  User: zhy
  Date: 2018/7/4
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>持名法州后台管理中心</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css"></link>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.validate.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/message_zh_CN.js"></script>

    <style type="text/css">
        #error{
            margin-left: 230px;
            margin-bottom: 10px;
            margin-top:-10px;
            color:red;
            font-weight: 600;
        }
        form label.error {	/* 表单错误信息的样式 */
            width: 200px;
            margin-left: 20px;
            color: Red;
            font-size: 12px;
            font-weight:600;
        }
    </style>

    <script type="text/javascript">

        $(function(){
            //点击更换验证码：
            $("#captchaImage").click(function(){
                $('#vcode').val("");
                $("#captchaImage").prop('src','${pageContext.request.contextPath}/admin/getCode?tm='+Math.random())
            });

            $('#loginForm').validate({
                rules:{
                    username:{required:true},
                    password:{required:true},
                    vcode:{required:true}
                },
                messages:{
                    username:{required:'请输入用户名！'},
                    password:{required:'请输入密码！'},
                    vcode:{required:'请输入密码！'}
                }
            })
        });


    </script>
</head>
<body>

<div class="login">
    <div id="error">
        ${sessionScope.errorMsg}
        <c:remove var="errorMsg" scope="session"></c:remove>
    </div>

    <form id="loginForm" action="${pageContext.request.contextPath}/admin/login" method="post" >

        <table>
            <tbody>
            <tr>
                <td width="190" rowspan="2" align="center" valign="bottom">
                    <img src="${pageContext.request.contextPath}/img/header_logo.gif" />
                </td>
                <th>
                    用户名:
                </th>
                <td>
                    <input type="text"  name="username" class="text" value="${uname}" placeholder="请输入用户名..." maxlength="20"/>
                </td>
            </tr>
            <tr>
                <th>
                    密&nbsp;&nbsp;&nbsp;码:
                </th>
                <td>
                    <input type="password" name="password" class="text" value="${pwd}" placeholder="请输入密码..." maxlength="20" autocomplete="off"/>
                </td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <th>验证码:</th>
                <td>
                    <input type="text" id="vcode" name="vcode" class="text captcha" maxlength="4" autocomplete="off"/>
                    <img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/admin/getCode" title="点击更换验证码"/>
                </td>
            </tr>
            <tr>
                <td>
                    &nbsp;
                </td>
                <th>
                    &nbsp;
                </th>
                <td>
                    <label>
                        <input type="checkbox" id="isRememberUsername" name="rm" value="true"/> 记住用户名
                    </label>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <th>&nbsp;</th>
                <td>
                    <input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit" class="loginButton" value="登录">
                </td>
            </tr>
            </tbody></table>
        <div class="powered">COPYRIGHT © 2008-2017.</div>
        <div class="link">
            <a href="http://www.chimingfowang.com/">持名佛网首页</a> |
            <a href="http://www.chimingbbs.com/">交流论坛</a> |
            <a href="">关于我们</a> |
            <a href="">联系我们</a> |
            <a href="">授权查询</a>
        </div>
    </form>
</div>
</body>
</html>