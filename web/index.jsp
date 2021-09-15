<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: YanTao
  Date: 2021/5/21
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>首页</title>
        <style>
            body{
                background-color: deepskyblue;
            }
            h3{
                width: 180px;
                height: 38px;
                line-height: 38px;
                border-radius: 5px;
                background-color: white;
                text-align: center;
                margin: 50px auto;
            }
            a{
                color: deepskyblue;
                font-size: 16px;
                text-decoration: none;
                font-weight: bolder;
            }
        </style>
    </head>
    <body>
    <shiro:guest>
        <h3>
            <a href="${pageContext.request.contextPath}/login.html">登录</a>
        </h3>
    </shiro:guest>
    <shiro:user>
        欢迎[<shiro:principal/>]登录！<a href="${pageContext.request.contextPath}/logout.html">注销</a>
        <h3>
            <a href="${pageContext.request.contextPath}/book/all">查询全部书籍</a>
        </h3>
    </shiro:user>
    </body>
</html>
