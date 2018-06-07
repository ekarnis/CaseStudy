<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
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
		<h1>Menu</h1>
		<table>  
	  <tr><th>Item</th><th>Picture</th><th>Description</th><th>Price</th><th>Add</th></tr>  
	  <tr><td>Hamburger</td><td><img src="Hamburger.jpg" width="150"></td><td>An amazing hamburger with lettuce, tomatoes, and ketchup</td><td>$3.50</td><td><button>Add</button></td></tr>  
	  <tr><td>Resturant</td><td><img src="Restaurants.jpg" width="150"></td><td>Why would you eat a restaurant?</td><td>$99999.99</td><td><button>Add</button></td></tr>  
	  <tr><td>Fries</td><td><img src="Fries.jpg" width="150"></td><td>Delicous hand cut fries with sea salt</td><td>$1.50</td><td><button>Add</button></td></tr>  
		</table>  
	</div>

	<footer>
		<p>123 example st, Phoenix, AZ, 12345</p>
		<p>123-456-7890</p>
	</footer>
   
</body>
  </html>
