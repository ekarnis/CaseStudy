<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager</title>
<link rel="stylesheet" type="text/css" href="css/universal.css">
<link rel="stylesheet" type="text/css" href="css/account.css">
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
		<section>
			<h2 id="title">Manager</h2>
		</section>

		<section>
			<article>
				<h3>Block Users</h3>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>	
			</article>
		</section>
		<section>
			<article>
				<h3>Change Menu</h3>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>	
			</article>
		</section>
		<section>
			<article>
				<h3>Change Stores</h3>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>	
			</article>
		</section>
		<section>
			<article>
				<h3>Change Specials</h3>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>	
			</article>
		</section>
		<section>
			<article>
				<h3>Change Combos</h3>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>
				<p>Lorem <button type="button">Click Me!</button> </p>	
			</article>
		</section>

	</div>

	<footer>
		<p>123 example st, Phoenix, AZ, 12345</p>
		<p>123-456-7890</p>
	</footer>

</body>
</html>