<%@page import="com.onlineshoping.bean.Product" %>
<%@page import="com.onlineshoping.bean.Customer"%>
<%@page import="com.onlineshoping.bean.ProductList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page</title>
<link rel="stylesheet" href="./main.css"> 
</head>
<body>
<nav>
<img src="Publicis_Sapient_Logo.jpg" alt="add crt Logo" class="logo">
 <ul> <li><a class="a1"> Welcome, ${fn: toUpperCase(sessionScope.customer.customerName)} !</a> </li> <li><a class="a2" href="./mycart"> Cart</a> </li><li><a class="a3"> Log Out</a> </li>
</ul>
</nav>
<div class="bg-img">
		<div class="container">
<main>
		<table class="view" >
			<thead>
				<tr>
					<th>Product ID</th>
					<th>Product Code</th>
					<th>Product Name</th>
					<th>Product Description</th>
					<th>Product Price</th>
					<th>Add To Cart</th>
				</tr>
			</thead>
			
			<c:forEach var = "i" begin = "0" end = "${sessionScope.productlist.getProducts().size()-1 }">
        		 <tr>
        		 <td>${sessionScope.productlist.getProducts().get(i).getId()}</td>
        		 <td>${sessionScope.productlist.getProducts().get(i).getCode()}</td>
        		 <td>${sessionScope.productlist.getProducts().get(i).getName()}</td>
        		 <td>${sessionScope.productlist.getProducts().get(i).getDescription()}</td>
        		 <td>${sessionScope.productlist.getProducts().get(i).getPrice()}</td>
        		 <td><form action="./addproductincart" method="post">
									<input type="text" name="item" value="${sessionScope.productlist.getProducts().get(i).getCode()}" hidden=""  >
									<input type="text" name="quantity" placeholder="1" class="namepass">
									<input type="submit" value="Add To Cart" class="btn">
											</form></td>
        		 </tr>
     		 </c:forEach>
			
		</table>
		
		<br>
	</main>
</div>
</div>


</body>
</html>