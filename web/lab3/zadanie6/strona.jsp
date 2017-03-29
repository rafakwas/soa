<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="movies" class="lab3.zadanie6.MoviesBean" scope="page"/>
<html>
<head>
    <title>filmy</title>
</head>
<body>

<h1>Lista filmów</h1>

<table border="1">
    <tbody>
    <tr>
        <th>Tytul</th>
        <th>Gatunek</th>
        <th>Rok</th>
        <th>Dochód</th>
    </tr>

    <fmt:setLocale value="en_US"/>
    <c:forEach items="${movies.movies}" var="movie">
        <fmt:formatNumber type="currency" value="${movie.income}" var="income" />
        <tr>
            <td><c:out value="${movie.title}"></c:out></td>

            <c:choose>


            <c:when test='${(movie.genre) eq "wojenny"}'>
                <c:set var="rowColor" value="green" scope="page"/>
            </c:when>
            <c:when test='${(movie.genre) ne "wojenny"}'>
                <c:set var="rowColor" value="white" scope="page"/>
            </c:when>

            </c:choose>

            <td bgcolor="${rowColor}"><c:out value="${movie.genre}"></c:out></td>

            <td><c:out value="${movie.year}"></c:out></td>

            <td><c:out value="${income}"/></td>
        </tr>
        </c:forEach>

    </tbody>
</table>
<br><br>

<%--<x:parse xml="${movies}" var="output"/>--%>
<%--<table border="1" width="100%">--%>
    <%--<x:forEach select="$output/movies/movie" var="movie">--%>
        <%--<tr>--%>
            <%--<td><x:out select="$movie/title"/></td>--%>
            <%--<td><x:out select="$movie/genre"/></td>--%>
            <%--<c:set var="income" value="2222"/>--%>
            <%--<fmt:formatNumber type="CURRENCY" value=<%=%>/>--%>
            <%--&lt;%&ndash;<c:choose>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<c:when test="${}"&ndash;%&gt;--%>
            <%--&lt;%&ndash;</c:choose>&ndash;%&gt;--%>

            <%--&lt;%&ndash;<td><fmt:formatNumber type="CURRENCY" value="${income}"/></td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<td><c:out value="${income}"/></td>&ndash;%&gt;--%>
        <%--</tr>--%>
    <%--</x:forEach>--%>
<%--</table>--%>

</body>
</html>