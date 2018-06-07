<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
<link rel="stylesheet" href="css/universal.css">
<style type="text/css">
td {
  text-align: center;
  vertical-align: middle;
}
th {
  text-align: center;
  vertical-align: middle;
}
</style>
</head>
<body>
	<nav>
		<div id="nav_container">
			<a href="/">Home </a>
			<a href="menu">Menu </a>
			<a href="about">About </a>
			<a href="contact">Contact </a>
			<c:choose>
			    <c:when test="${sessionScope.currentUser!=null}">
			        <a href="account">My Account</a>
			        <a href="logout">Logout</a>
			        <!-- Need to have sessions blocking account/logout pages with redirect so that they can't be accessed without logging in -->
			        <br />
			    </c:when> 
			    <c:otherwise>
			        <a href="login">Login</a>
					<a href="register">Register</a> 
			        <br />
			    </c:otherwise>
			</c:choose>
			<a></a>
		</div>
	</nav>
	
	<div id="main_container">
		<h1>Orders</h1>
		<table>  
	  		<tr>
	  			<th>Order Id</th>
	  			<th>User Id</th>
	  			<th>Placed time</th>
	  			<th>Instructions</th>
	  			<th>Delivery Method</th>
	  			<th>Store</th>
	  			<th>Delivery Status</th>
	  		</tr>  
	  		<tr>
	  			<td>123</td>
	  			<td>312</td>
	  			<td>23:40 May 23, 2018</td>
	  			<td>make it good</td>
	  			<td>hand</td>
	  			<td>deer valley</td>
	  			<td>omw</td>
	  		</tr>  
	  		<tr>
	  			<td>123</td>
	  			<td>312</td>
	  			<td>23:40 May 23, 2018</td>
	  			<td>make it good</td>
	  			<td>hand</td>
	  			<td>deer valley</td>
	  			<td>omw</td>
	  		</tr>  
	  		<tr>
	  			<td>123</td>
	  			<td>312</td>
	  			<td>23:40 May 23, 2018</td>
	  			<td>make it good</td>
	  			<td>hand</td>
	  			<td>deer valley</td>
	  			<td>omw</td>
	  		</tr>  
		</table>  
	</div>

	<footer>
		<p>123 example st, Phoenix, AZ, 12345</p>
		<p>123-456-7890</p>
	</footer>
   
</body>
  </html>
