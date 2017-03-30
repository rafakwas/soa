<%@ page import="lab3.zadanie3.UserFeedback" %>
<%@ page import="java.io.FileWriter" %>
<%@ page import="java.io.BufferedWriter" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Vector" %><%--
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


<%!
        public static void writeToFile(Collection<UserFeedback> collection) {
            BufferedWriter bw = null;
            FileWriter fw = null;

            StringBuilder stringBuilder = new StringBuilder();
            for(UserFeedback user: collection) {
                stringBuilder.append(user.getLogin());
                stringBuilder.append(";");
                stringBuilder.append(user.getComment());
                stringBuilder.append(";");
                stringBuilder.append(user.getEmail());
                stringBuilder.append(";");
                stringBuilder.append(user.getId());
                stringBuilder.append("\n");

            }
            String path = "/home/ralphigi/Dokumenty/soa/lab3/zadanie3Comments.txt";

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
%>

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
        writeToFile(vector);
        response.sendRedirect("bookSite.jsp");

    }

%>

</body>
</html>
