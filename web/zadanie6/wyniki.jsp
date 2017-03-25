<%@ page import="com.agh.edu.pl.soa.lab1.zadanie6.EkspertPiwny" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ralphigi
  Date: 23.03.17
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wyniki</title>
</head>
<body>
<%
    String color = (String) application.getAttribute("color");
    EkspertPiwny ekspertPiwny = (EkspertPiwny) application.getAttribute("ekspert");
    List<String> list = ekspertPiwny.chooseBeer(color);
    for (String beer : list) {
        out.println("<b>" + beer + "<b></br>");
    }
%>
