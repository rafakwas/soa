<%--<%@ page import="org.w3c.dom.Document" %>--%>
<%--<%@ page import="org.jcp.xml.dsig.internal.dom.DOMUtils" %>--%>
<%--<%@ page import="org.w3c.dom.Element" %>--%>
<%--<%@ page import="org.w3c.dom.Node" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<html>
<head>
    <title>shop</title>
</head>
<body>
<h3>Przedmioty:</h3>
<c:import var="computerParts" url="http://localhost:8080/computer_parts.xml"/>

<x:parse xml="${computerParts}" var="output"/>
<b>Lista czesci</b>:
<x:out select="$output/computer_parts/part[1]/name" />
<br>
<x:out select="$output/computer_parts/part[2]/name" />

</body>
</html>