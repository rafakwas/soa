<%@ page import="java.io.*" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Collection" %>
<%@ page import="lab3.zadanie3.UserFeedback" %><%--
  Created by IntelliJ IDEA.
  User: ralphigi
  Date: 26.03.17
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Write comments to file</title>
</head>
<body>


<%!
    public static void writeToFile(Collection<UserFeedback> collection) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        StringBuilder stringBuilder = new StringBuilder();
        for(UserFeedback user: collection) {
            stringBuilder.append(user.getLogin());
            stringBuilder.append(";");
            stringBuilder.append(user.getEmail());
            stringBuilder.append(";");
            stringBuilder.append(user.getComment());
            stringBuilder.append(";");
            stringBuilder.append(user.getId());
            stringBuilder.append("\n");

        }
        String path = "komentarze.txt";

        try {

            fw = new FileWriter(path,false);
            bw = new BufferedWriter(fw);
            bw.append(stringBuilder.toString());

            System.out.println("written");

        } catch (IOException e) {

            System.out.println(e.getMessage());

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                System.out.println(ex.getMessage());

            }

        }

        System.out.println("jestem w jsp writetofile");

    }
//    StringBuilder stringBuilder = new StringBuilder();
//    Vector<UserFeedback> vector = (Vector<UserFeedback>) application.getAttribute("vector");
//    for (UserFeedback entry : vector) {
//        out.print("<b>" + entry.getLogin() + "</b> (" + entry.getEmail() + ") says </br>");
//        out.println("<t>" + entry.getComment() + "</br>");
//    }
%>

<%
    if (application.getAttribute("vector") != null) {
        writeToFile((Vector<UserFeedback>)application.getAttribute("vector"));
    }
    response.sendRedirect("bookSite.jsp");
%>

</body>
</html>
