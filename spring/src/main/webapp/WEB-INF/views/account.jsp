<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account </title>
<link rel="stylesheet" type="text/css" href="css/universal.css">
<link rel="stylesheet" type="text/css" href="css/account.css">
<script src="home.js"></script>
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
		</div>
	</nav>
	<div id="main_container">
		<section>
			<h2 id="title">Account</h2>
		</section>

		<section>
			<article>
				<h3>Current Order</h3>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>	
			</article>
		</section>
		<section>
			<article>
				<h3>Past Orders</h3>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>	
			</article>
		</section>
		<section>
			<article>
				<h3>Account Settings</h3>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>	
			</article>
		</section>
		<section>
			<article>
				<ul style="padding:0px;list-style-type:none;"><h3>Account Details</h3>
					<li><b>First name:</b> ${sessionScope.currentUser.firstName} </li>
					<li><b>Last name: </b> ${sessionScope.currentUser.lastName} </li>
					<li><b>Phone number: </b> ${sessionScope.currentUser.phoneNumber} </li>
					<li><b>Email address: </b> ${sessionScope.currentUser.email} </li>
					<li><a href="account/accountEdit">Edit account information</a></li>
				</ul>
			</article>
		</section>

	</div>

	<footer>
		<p>123 example st, Phoenix, AZ, 12345</p>
		<p>123-456-7890</p>
	</footer>

</body>
</html>