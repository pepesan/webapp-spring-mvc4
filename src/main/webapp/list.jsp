<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
<head><title>Listado</title></head>
<body>
<h1>Listado de productos</h1>
<p> <c:out value="${model.now}"/></p>
<br>
<p><a href="<c:url value="priceincrease.htm"/>">Increase Prices</a></p>
<br>
<h3>Products</h3>
<c:forEach items="${model.products}" var="prod">
    <c:out value="${prod.description}"/>
    <i>$<c:out value="${prod.price}"/></i><br><br>
</c:forEach>
</body>
</html>