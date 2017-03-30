<%@ page import="lab3.zadanie3.Validation" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Vector" %>
<%@ page import="lab3.zadanie3.UserFeedback" %>
<%@ page import="java.io.FileOutputStream" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileReader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Zadanie 3 quests</title>
</head>
<%
    String user = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("guestCookie")) {
                user = cookie.getValue();
            }
        }
    }
    if (user == null) {
        response.sendRedirect("loginSite.jsp");
    }
%>


<%!
    public static Vector<UserFeedback> readFromFile() {
        BufferedReader br = null;
        FileReader fr = null;

        Vector<UserFeedback> vector = new Vector<>();
        String path = "komentarze.txt";

        try {

            fr = new FileReader(path);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                String[] splitter = sCurrentLine.split(";");
                UserFeedback userFeedback = new UserFeedback(splitter[0],splitter[1],splitter[2],Long.parseLong(splitter[3]));
                vector.add(userFeedback);
            }

            System.out.println("read");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (Exception ex) {

                System.out.println(ex.getMessage());

            }

        }

        return vector;
    }
//    StringBuilder stringBuilder = new StringBuilder();
//    Vector<UserFeedback> vector = (Vector<UserFeedback>) application.getAttribute("vector");
//    for (UserFeedback entry : vector) {
//        out.print("<b>" + entry.getLogin() + "</b> (" + entry.getEmail() + ") says </br>");
//        out.println("<t>" + entry.getComment() + "</br>");
//    }
%>


<body>
<b>Please submit your feedback:</b>
<form method="post" action="/lab3/zadanie3/book">
    Your name: <input type="text" name="login"> <br/>
    Your email: <input type="text" name="email"><br/>
    Comment: <input type="text" name="comment"> <br/>
    <input type="submit" value="Send feedback">
</form>

<%


    if (application.getAttribute("vector") != null) {
        Vector<UserFeedback> vector = readFromFile();
        for (UserFeedback entry : vector) {
            out.print("<b>" + entry.getLogin() + "</b> (" + entry.getEmail() + ") says");
            %>
            <%
                long temp = entry.getId();
                pageContext.setAttribute("id",temp);
            %>
                <a href="edit.jsp?commentId=${pageContext.getAttribute("id")}">edit</a>
            <%
            out.print("<br/>");
            out.println("<t>" + entry.getComment() + "</br>");
        }
    } else {
        out.print("<b> no feedback yet </b>");
    }
%>


<br>
<a href="/lab3/zadanie3/logout">Logout</a>




</body>
</html>
