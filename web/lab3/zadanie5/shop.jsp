<%@ page import="java.util.Map" %><%--<%@ page import="org.w3c.dom.Document" %>--%>
<%--<%@ page import="org.jcp.xml.dsig.internal.dom.DOMUtils" %>--%>
<%--<%@ page import="org.w3c.dom.Element" %>--%>
<%--<%@ page import="org.w3c.dom.Node" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<jsp:useBean id="cartBean" class="lab3.zadanie5.CartBean" scope="session"/>
<html>
<head>
    <title>shop</title>
</head>
<body>
<h3>Przedmioty:</h3>
<c:import var="computerParts" url="http://localhost:8080/computer_parts.xml"/>

Koszyk:
<br/>

<x:parse xml="${computerParts}" var="output"/>
<%
    for(Map.Entry<Integer,Integer> entry : cartBean.getCart().entrySet()) {
        %>
        <c:set var="partId">
            <%=entry.getKey()%>
        </c:set>

        <x:out select="$output/computer_parts/part[$partId]"/>: <%= entry.getValue() %> sztuk

        <br/>
        <%
    }

%>



<form action="managment.jsp">
    <select name="partId">
        <x:forEach select="$output/computer_parts/part" var="part">
            <option value=<x:out select="$part/@id"/>> id:<x:out select="$part/@id"/> nazwa : <x:out select="$part/name"/>  cena:  <x:out select="$part/price"/> </option>
        </x:forEach>
    </select>
    <br/>
    Podaj liczbę dodawanych/odejmowanych produktów: <input type="text" name="amount">
    <br/>
    <input type="submit" name="action" value="add">
    <input type="submit" name="action" value="remove">
</form>


<%--<x:parse xml="${computerParts}" var="output"/>--%>
<%--<b>Lista czesci</b>:--%>
<%--<x:out select="$output/computer_parts/part[1]/name" />--%>
<%--<br>--%>
<%--<x:out select="$output/computer_parts/part[2]/name" />--%>

</body>
</html>