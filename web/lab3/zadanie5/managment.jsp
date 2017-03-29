<%--
  Created by IntelliJ IDEA.
  User: ralphigi
  Date: 29.03.17
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<jsp:useBean id="cartBean" class="lab3.zadanie5.CartBean" scope="session"/>


<html>
<head>
    <title>zarzadzanie kosykiem</title>
</head>
<body>


<%
    if(request.getParameter("partId") != null) {
        Integer amount = Integer.parseInt(request.getParameter("amount"));
        if(request.getParameter("action").equals("add")) {
            for(int i = 0; i<amount;i++)
                cartBean.add(Integer.parseInt(request.getParameter("partId")));
        }
        else {
            for(int i = 0; i<amount;i++)
                cartBean.remove(Integer.parseInt(request.getParameter("partId")));
        }
    }
    response.sendRedirect("shop.jsp");
%>



</body>
</html>
