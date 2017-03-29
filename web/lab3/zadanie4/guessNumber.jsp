<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zgadnij liczbe</title>
</head>

<%!
    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return min+random.nextInt(max+1);
    }
%>

<%
    if(request.getParameter("again") != null) {
        session.invalidate();
    }
    HttpSession httpSession = request.getSession(true);
    boolean firstIteration = httpSession.isNew();
    Integer number;
    Integer counter = 0;

//    unika rekurencji
    if (firstIteration) {
        number = getRandomNumber(0,100);
        counter = 0;
    }
    else {
        number = Integer.parseInt((String)request.getParameter("number"));
        counter = Integer.parseInt((String)request.getParameter("counter")) + 1;
    }


    final String guessString = request.getParameter("guess");
    int guess = 0;
    String message = null;

    if (guessString == null) {
%>
    <body>
    First iteration: </br>
    <form method="get">
        Liczba: <input type="text" name="guess"></br>
        <input type="hidden" name="number" value="<%=number%>" />
        <input type="hidden" name="counter" value="<%=counter%>" />
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
    if (number == null) {
        System.out.println("number jest nullem!");
    }
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
        message = "Brawo, zgadła(e)ś po " + counter + " próbach. Spróbuj "; %>
        <a href="guessNumber.jsp?again=1">raz jeszcze</a>
    <%
    }

%>
<%= message %>
<%
    }
%>
<body>
Next iterations: </br>
<form method="get">
    Liczba: <input type="text" name="guess"></br>
    <input type="hidden" name="number" value="<%=number%>" />
    <input type="hidden" name="counter" value="<%=counter%>" />
    <input type="submit">
</form>
</body>
<%















}

%>



</html>
