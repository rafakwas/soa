<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: ralphigi
  Date: 26.03.17
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zgadnij liczbe</title>
</head>

<%!
    private static int getRandomNumber(int min, int max) {
        Random random = new Random(47);
        return min+random.nextInt(max+1);
    }
%>


<%
    final HttpSession httpSession = request.getSession();
    final boolean firstIteration = session.isNew();
    Integer number = 0;
//    Integer counter = 0;

//    unika rekurencji
    if (firstIteration) {
        number = getRandomNumber(0,100);
        request.setAttribute("number",number);
//        request.setAttribute("counter",counter);
    }
    else {
        try {
            number = (Integer)request.getAttribute("number");
        }
        catch (Exception e) {
            System.out.println("ERROR 1");
            System.out.println(e.getMessage());
        }
//        counter = Integer.parseInt((String)request.getAttribute("counter"));
//        counter += 1;
//        request.setAttribute("counter",counter.toString());

    }

    final String guessString = request.getParameter("guess");
    int guess = 0;
    String message = null;

    if (guessString == null) {
%>
    <body>
    First iteration: </br>
    <form method="post">
        Liczba: <input type="text" name="guess"></br>
        <input type="submit">
    </form>
    </body>
<%
    }
    else {
        if (guessString.length() != 0) {
            try {
                guess = Integer.parseInt(guessString);
            } catch (NumberFormatException e) {
                message = "Guess nie jest poprawna liczba: " + guessString;
            }
        } else {
            message = "Guess jest pusty";
        }
        if (message != null) {

%>
            <%= message %>
<%
} else {
    if (guess != number.intValue()) {
        // komunikat
        if (guess < number.intValue()) {
            message = "Twoja liczba ("+guess+") jest mniejsza niż zagadka";
        }
        else {
            message = "Twoja liczba ("+guess+") jest większa niż zagadka";
        }
    }
    else {
        // wygrana
        message = "Brawo, zgadła(e)ś po próbach.";
    }

%>
<%= message %>
<%
    }
%>
<body>
Next iterations: </br>
<form method="post">
    Liczba: <input type="text" name="guess"></br>
    <input type="submit">
</form>
</body>
<%















}


%>



</html>