<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List All Shares</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Shares</h2>	
	<table>
		<tr>
			<td>SYMBOL</td>
			<td>PRICE</td>
			<td>QUANTITY</td>
			<td>VALUE</td>
			<td>JOINING DATE</td>
		</tr>
		<c:forEach items="${shares}" var="share">
			<tr>
			<td>${share.symbol}</td>
			<td>${share.price}</td>
			<td>${share.quantity}</td>
			<td>${share.value}</td>
			<td>${share.joiningDate}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new' />">Add New share</a>
</body>
</html>