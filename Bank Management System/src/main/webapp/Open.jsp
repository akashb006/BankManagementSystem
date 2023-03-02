<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"  href="register.css">
<title>Account Opening</title>
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
<h1>Open Savings Account</h1>
<form action="OpenServlet" method="post">
<div class="in">
<input type="text" placeholder="Enter Name" name="name" required="required"><br><br>
<input type="number" placeholder="Enter Adhaar Number" name="adhar" required="required"><br><br>
<input type="text" placeholder="Enter Pan Number" name="pan" required="required"><br><br>
<input type="tel" placeholder="Enter Mobile Number" name="mobile" required="required"><br><br>
<input type="text" placeholder="Enter Adress" name="adress" required="required"><br><br>
<input type="text" placeholder="Enter Father Name" name="fname" required="required"><br><br>
<input type="text" placeholder="Enter Mother Name" name="mname" required="required"><br><br>
<input style="width:40px;"type="checkbox" placeholder="Accept T & C" name="check" required="required"><span style="margin-right: 20px;">Accept T&C <a href="tc.html" style="color:red">click here</a></span><br><br>
<button type="submit" id="btn">Open Account</button>
</div>
</form>
</div>
</div>
</body>
</html>