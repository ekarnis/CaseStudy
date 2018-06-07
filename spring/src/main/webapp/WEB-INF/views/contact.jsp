<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact</title>
<link rel="stylesheet" type="text/css" href="css/universal.css">
<link rel="stylesheet" type="text/css" href="css/register.css">
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
			<a></a>
		</div>
	</nav>
	<div id="main_container">
		<div id="spacer"></div>
		<div id="section_container">
			<section>
				<div id="form_container">
					<form>
					  Email<br>
					  <input type="email" name="email" value="example@test.com">
					  <br>
					  Message<br>
					  <input type="text" name="password">
					  <br><br>
					  <input type="submit" value="Submit">
					</form> 
				</div>
			</section>
		</div>

	</div>

	<footer>
		<p>123 example st, Phoenix, AZ, 12345</p>
		<p>123-456-7890</p>
	</footer>

</body>
</html>