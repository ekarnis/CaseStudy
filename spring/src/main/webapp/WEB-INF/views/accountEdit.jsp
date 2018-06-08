<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Account </title>
<link rel="stylesheet" type="text/css" href="../css/universal.css">
<link rel="stylesheet" type="text/css" href="../css/account.css">
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
		<div id="spacer"></div>
		<div id="section_container">
			<section>
				<div id="form_container">
					<form:form method="POST" modelAttribute="newUser" class="form-horizontal">
						<div>
							Email:<form:input type="email" path="email" value="${sessionScope.currentUser.email}" />
					  		<form:errors path="email" cssClass="error" />
					  	</div>
					  	
					  	<div>
					  		Password:<form:input type="password" path="password" id="password" value="${sessionScope.currentUser.password}"/>
					  		<form:errors path="password" cssClass="error" />
					  	</div>
					  
					  	<div>
					  		Confirm Password:<form:input type="password" path="confirmPassword" id="confirmPassword" value="${sessionScope.currentUser.password}"/>
					  		<form:errors path="confirmPassword" cssClass="error" />
					  	</div>
					  	
					  	<div>
					  		First Name:<form:input type="text" path="firstName" placeholder="First Name" value="${sessionScope.currentUser.firstName}"/>
					  		<form:errors path="firstName" cssClass="error" />
					  	</div>
					  	
					  	<div>
					  		Last Name:<form:input type="text" path="lastName" placeholder="Last Name" value="${sessionScope.currentUser.lastName}"/>
					  		<form:errors path="lastName" cssClass="error" />
					  	</div>
					  	
					  	<div>
					  		Phone Number:<form:input type="text" path="phoneNumber" placeholder="123-123-1234" value="${sessionScope.currentUser.phoneNumber}"/>
					  		<form:errors path="phoneNumber" cssClass="error" />
					  	</div>
					  	
					  	<div>
					  		<input type="submit" value="Save">
					  	</div>
					</form:form> 
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