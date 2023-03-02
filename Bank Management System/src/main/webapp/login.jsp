
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"  href="register.css">
<title>Prakruthi Bank Login</title>
</head>
<body>

<div class="nav">
<div class="nav1">
<img alt="Bank Logo" src="banklogo.png" width=40px>
<h1>Pr<span style="color:green; font-family: cursive;">ak</span>ruthi Bank  </h1>

</div>
<div >

<ul class="nav2">
<a href="login.jsp"><li id="ac">NetBanking Login</li></a>
<a href="Open.jsp"><li id="ac">Open Account<select>
<option>Savings Account</option>
<option>Salary Account</option>
<option>Current Account</option>
</select></li></a>
<a href="Register.html"><li id="ac">About Us</li></a>
<a href=""><li id="ac">Notification</li></a>
<a href=""><li id="ac">Contact Us</li></a>
</ul>
</div>
</div>
<div class="cen">
<div class="container">
<h4 style="color:red; text-align: center;"><% if(session.getAttribute("msg1")!=null) {%><%=session.getAttribute("msg1")  %><%} %></h4>
<h1>Login Your Account</h1>
<form action="LoginServlet" method="post">
<div class="in">
<input type="text" placeholder="Enter UserId" name="uid" required="required"><br><br>
<input type="text" placeholder="Enter Password" name="pwd" required="required"><br><br>
<a style="text-decoration: none; color:blue;" href="forgot.jsp" ><p style="margin-left:280px; margin-bottom: 10px;">forgot user id ?</p></a>

<button type="submit" id="btn">Login</button>
</div>
</form>
</div>
</div>
</body>
</html>