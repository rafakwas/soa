<%--
  Created by IntelliJ IDEA.
  User: ralphigi
  Date: 25.03.17
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/bodyTagSupport.tld" prefix="dev" %>


<ct:form></ct:form>
</br>
<ct:sort increasing="1" color="red"></ct:sort>
<dev:formattingTag header="FORMATTING TAG" adjust="right" color="red">AUTORA WITAM, O POGODE PYTAM</dev:formattingTag>
Zamiana 20 EURO na CHF: <ct:currency value="20.0" incomeCurrency="EUR" outcomeCurrency="CHF"></ct:currency>

