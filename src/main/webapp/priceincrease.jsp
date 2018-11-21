<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Increase Prices</title>
    <style>
        .error { color: red; }
    </style>
</head>
<body>
<h1>Increase Prices</h1>
<form:form method="post" commandName="priceIncrease">
    <table >
        <tr>
            <td align="right" width="20%">Increase (%):</td>
            <td width="20%">
                <form:input path="percentage"/>
            </td>
            <td width="60%">
                <form:errors path="percentage" cssClass="error"/>
            </td>
        </tr>
    </table>
    <br>
    <input type="submit" value="Execute">
</form:form>
<a href="<c:url value="hello.htm"/>">Home</a>
</body>
</html>

