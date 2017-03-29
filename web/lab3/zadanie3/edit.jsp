<%--
  Created by IntelliJ IDEA.
  User: ralphigi
  Date: 29.03.17
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit comment</title>
</head>
<body>



<%
    String temp = null;
    synchronized (this) {
        if (application.getAttribute(request.getParameter("commentId")) == null) {
            temp = request.getParameter("commentId");
            application.setAttribute(temp,"occupied");
        }
        else {
            response.sendRedirect("bookSite.jsp");
        }
    }
%>

Edit:

<form action="editingComment.jsp">
    <input type="text" name="change">
    <input type="hidden" name="commentId" value="<%=temp%>">
    <input type="submit">
</form>

<%

%>

</body>
</html>
