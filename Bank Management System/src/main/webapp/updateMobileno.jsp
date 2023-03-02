<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"  href="register.css">
<title>Update Mobile No</title>
</head>
<body>
<%if(session.getAttribute("name")!=null){ %>
<div class="nav" style="background: grey;">
<div class="nav1">
<img alt="Bank Logo" src="banklogo.png" width=40px>
<h1>Pr<span style="color:green; font-family: cursive;">ak</span>ruthi Bank  </h1>

</div>
<div >

<ul class="nav2">
<a href="update.jsp"><li id="ac" style="padding:10px;">update pin</li></a>

<a href="updateMobileno.jsp"><li id="ac" style="background: green; padding:12px;">update mobileno</li></a>


<a href="Welcome.jsp"><li id="ac" style="padding:10px;">back</li></a>
</ul>
</div>
</div>
<%if(session.getAttribute("msgup2")!=null){%><%= session.getAttribute("msgup2") %><%} %>
<div class="secw" style="display: flex; justify-content: center;">
<div class="boxw" style="width:400px; hight:300px; border:1px solid black; background:green; margin-top:50px;padding:30px; border-radius: 10px;">
<div class="menu" style="display: flex; justify-content:space-between;align-items: center; margin-bottom: 15px;">
<h2 style="text-align: center; letter-spacing:3px;">Prakruthi Bank</h2>
</div>
<hr>
<form action="UpdateMob" method="post">
<div style="font-variant: small-caps; color:white; margin-top: 10px;"> <b>Update MobileNo  :<input type="tel" placeholder="Enter Mobileno" name="mobno1"  required="required"></div><br>
<div style="font-variant: small-caps; color:white; margin-top: 10px;"> <b>confirm MobileNo  :<input type="tel" placeholder="confirm Mobileno" name="mobno2" required="required"></div><br>
<div style="font-variant: small-caps; color:white;">Account Name   :  <span><%= session.getAttribute("name")%></span></div><br>
<div><button style="padding:10px 30px; border:none; background:orange; font-size: 15px; color:white; cursor: pointer;">Update</button> </div>
</form>


</div>

</div>
<%} else{%><% response.sendRedirect("login.jsp"); %><%} %>
</body>
</html>