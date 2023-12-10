<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Product List Page</h1>
		<c:if test="${not empty message}">
		${message}<br>
		</c:if>
		<a href="${pageContext.request.contextPath}/product/addnew">Add new Product</a><br />
		<form action="${pageContext.request.contextPath}/product/search" method="get">
			<input type="text" name="keySearch">
			<button type="submit">Search</button>
		</form>
		<table border="1" style="width: 700px; text-align: center;">
			<tr>
				<td>Name</td>
				<td>Color</td>
				<td>Quantity</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.name}</td>
					<td>${product.color}</td>
					<td>${product.quantity}</td>
					<td><a href="/product/edit/${product.id}">Edit</a></td>
					<td><a href="/product/delete/${product.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="pagination">
			<c:if test="${currentPage > 1}">
				<a href="${pageContext.request.contextPath}/product?page=${currentPage-1}">Previous</a>
			</c:if>

			<c:forEach begin="1" end="${totalPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<a class="active"> ${i} </a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/product?page=${i}">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:if test="${currentPage lt totalPages}">
				<a href="${pageContext.request.contextPath}/product?page=${currentPage+1}">Next</a>
			</c:if>
		</div>
	</div>

</body>
</html>