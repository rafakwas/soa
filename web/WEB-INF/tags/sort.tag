<%@ tag import="java.util.Collections" %>
<%@ tag import="java.util.Collection" %>
<%@ tag import="lab3.zadanie2.com.example.model.User" %>
<%@ tag import="java.util.Comparator" %>
<%@ tag import="lab3.zadanie2.com.example.model.UserRepo" %>
<%@ tag import="java.util.List" %>
<%@ attribute name="increasing" required="true" %>
<%@ attribute name="color" required="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%
    UserRepo repoTemp = (UserRepo)application.getAttribute("userRepo");
    if (repoTemp != null) {
        List<User> collection = repoTemp.getList();

        if (increasing.equals("1")) {
            Collections.sort(collection);
        }
        else {
            Collections.sort(collection, Collections.reverseOrder());
        }
        System.out.println(collection);
        request.setAttribute("coll",collection);
    }

%>

<c:forEach var="user" items="${requestScope.coll}">
    ${user.login} : <font color=${color}> ${user.time} </font><br/>
</c:forEach>

