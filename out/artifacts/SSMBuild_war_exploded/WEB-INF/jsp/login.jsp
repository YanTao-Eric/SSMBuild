<%--
  Created by IntelliJ IDEA.
  User: YanTao
  Date: 2021/9/12
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/layui/2.6.8/css/layui.css" media="all">
</head>
<body style="background-color: #2CA6FF; ">
<div style="width: 375px; height: 250px; margin: 200px auto; background-color: white; border-radius: 8px; ">
    <form class="layui-form" action="${pageContext.request.contextPath}/login" method="post">
        <div style="margin: 10px auto; text-align: center; ">
            <h2>登录</h2>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" for="username">Username:</label>
            <div class="layui-input-inline">
                <input type="text" name="username" id="username" autocomplete="off" class="layui-input" autofocus/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" for="password">Password:</label>
            <div class="layui-input-inline">
                <input type="password" name="password" id="password" autocomplete="off" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <input type="checkbox" name="rememberMe" id="rememberMe" lay-skin="primary" title="两周内免登录">
            </div>
        </div>
        <button type="submit" class="layui-btn layui-btn-normal" style="margin-left: 15px;">LOGIN</button>
        <button type="reset" class="layui-btn layui-btn-primary" style="float: right; margin-right: 15px;">RESET</button>
    </form>
</div>


<script src="https://cdn.staticfile.org/layui/2.6.8/layui.js" charset="UTF-8"></script>
</body>
</html>

