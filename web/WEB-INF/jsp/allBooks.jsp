<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YanTao
  Date: 2021/5/22
  Time: 13:02
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
    <title>查询全部书籍</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/4.6.0/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>书籍列表——全部书籍</small>
                    </h1>
                </div>
            </div>
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAdd">添加书籍</a>
            </div>
<%--            查询书籍--%>
            <div class="col-md-4 column form-inline">
                <form action="${pageContext.request.contextPath}/book/search" method="post">
                    <label for="bookName"></label><input type="text" class="form-control" id="bookName" name="bookName" placeholder="请输入要查询的书籍名称"/>
                    <button type="submit" class="btn btn-danger col-xs-4">搜&nbsp;&nbsp;索</button>
                </form>
            </div>
        </div>

        <div class="row clearfix" style="margin-top: 10px">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>书籍编号</th>
                        <th>书籍名称</th>
                        <th>书籍数量</th>
                        <th>书籍描述</th>
                        <th>书籍操作</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="book" items="${books}">
                            <tr>
                                <td>${book.bookId}</td>
                                <td>${book.bookName}</td>
                                <td>${book.bookCount}</td>
                                <td>${book.detail}</td>
                                <td>
                                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toUpdate/${book.bookId}">更改</a>
                                    &nbsp;&nbsp;|&nbsp;&nbsp;
                                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/delete?id=${book.bookId}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
