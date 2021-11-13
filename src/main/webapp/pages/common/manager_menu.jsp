<%--
  Created by IntelliJ IDEA.
  User: 无限熵增
  Date: 2021/10/28
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
  <a href="${pageContext.request.contextPath}/manager/bookServlet?action=page">图书管理</a>
  <a href="${pageContext.request.contextPath}/manager/managerOrderServlet?action=allOrders">订单管理</a>
  <a href="${pageContext.request.contextPath}/index.jsp">返回商城</a>
</div>
