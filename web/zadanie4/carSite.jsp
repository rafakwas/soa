<%--
  Created by IntelliJ IDEA.
  User: ralphigi
  Date: 14.03.17
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Formularz do zadania 4</title>
  </head>

  <body>
  <form method="post" action="/hello/zadanie4">
    Przedział cenowy: <input type="text" title="Przedzial cenowy" name="range"> <br/>
    Rodzaj samochodu: <select name="type">
    <option value="sport">sportowy</option>
    <option value="luxurious">luksusowy</option>
    <option value="urban">miejski</option>
  </select>
    <br/>
    <input type="submit">
    <input type="reset">

  </form>

  </body>
</html>
