<%@ page import="java.util.Vector" %>
<%@ page import="lab3.zadanie3.UserFeedback" %><%--
  Created by IntelliJ IDEA.
  User: ralphigi
  Date: 29.03.17
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>editing</title>
</head>
<body>

<%
    synchronized (this) {
        Vector<UserFeedback> vector = (Vector<UserFeedback>)application.getAttribute("vector");
        UserFeedback user = new UserFeedback();
        Long id = Long.parseLong(request.getParameter("commentId"));
        System.out.println("id="+id);
        user.setId(id);
        int index = vector.indexOf(user);
        UserFeedback userFeedback = vector.get(index);
        System.out.println("index="+index);
        userFeedback.setComment(request.getParameter("change"));
        vector.remove(index);
        vector.add(userFeedback);
        application.setAttribute("vector",vector);
        application.removeAttribute(id.toString());
        response.sendRedirect("bookSite.jsp");

    }

%>

</body>
</html>
