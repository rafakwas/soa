<%@ tag import="java.util.ResourceBundle" %>
<%@ tag import="javax.annotation.Resource" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%!
    public static Double calculate(Double value, String incomeCurrency, String outcomeCurrency) {
        ResourceBundle resource = ResourceBundle.getBundle("currencyExchange");
        Double incomeCourse = Double.parseDouble(resource.getString(incomeCurrency));
        System.out.println(incomeCourse);
        Double outcomeCourse = Double.parseDouble(resource.getString(outcomeCurrency));
        System.out.println(outcomeCourse);
        return (outcomeCourse/incomeCourse)*value;
    }
%>
<%= calculate(10.0,"EUR","USD") %>