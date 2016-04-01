<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add New Share Price</title>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<h2>Add New Share Price</h2>
 
	<form:form method="POST" modelAttribute="share">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="symbol">Symbol: </label> </td>
				<td><form:input path="symbol" id="symbol"/></td>
				<td><form:errors path="symbol" cssClass="error"/></td>
		    </tr>

		    <tr>
				<td><label for="quantity">Quantity: </label> </td>
				<td><form:input path="quantity" id="quantity"/></td>
				<td><form:errors path="quantity" cssClass="error"/></td>
		    </tr>


			<tr>
				<td colspan="3">
					<input type="submit" value="Add"/>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	Go back to <a href="<c:url value='/list' />">List of All shares</a>
</body>
</html>