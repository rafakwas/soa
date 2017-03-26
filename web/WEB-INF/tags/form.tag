
<%
    if (session.getAttribute("login") != null) {

    %>
        <a href="/lab3/zadanie2/logoutSession">Logout</a>
    <%

    }
    else {
    %>
        <form method="post" action="/lab3/zadanie2/loginManagment">
            Login:<input type="text" name="login">
            Password:<input type="password" name="password">
            <input type="submit">
            <input type="reset">
        </form>
    <%

    }
%>