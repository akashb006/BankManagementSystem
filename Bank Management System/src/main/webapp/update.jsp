<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"  href="register.css">
<title>Update UPI pin</title>
</head>
<body>

<%if(session.getAttribute("name")!=null){ %>
<div class="nav" style="background: grey;">
<div class="nav1">
<img alt="Bank Logo" src="banklogo.png" width=40px>
<h1>Pr<span style="color:green; font-family: cursive;">ak</span>ruthi Bank  </h1>

</div>
<div >

<ul class="nav2" >
<a href="update.jsp"><li id="ac" style="background: green;padding:12px;">update pin</li></a>

<a href="updateMobileno.jsp"><li id="ac" style="padding:10px;">update mobileno</li></a>


<a href="Welcome.jsp"><li id="ac" style="padding:10px;">back</li></a>
</ul>
</div>
</div>
<%if(session.getAttribute("msgup1")!=null){%><%= session.getAttribute("msgup1") %><%} %>
<div class="secw" style="display: flex; justify-content: center;">
<div class="boxw" style="width:400px; hight:300px; border:1px solid black; background:green; margin-top:50px;padding:30px; border-radius: 10px;">
<div class="menu" style="display: flex; justify-content:space-between;align-items: center; margin-bottom: 15px;">
<h2 style="text-align: center; letter-spacing:3px;">Prakruthi Bank</h2>

</div>
<hr>
<form action="Update" method="post">
<div style="font-variant: small-caps; color:white; margin-top: 10px;"> <b>Update UPI pin  :<input type="number" placeholder="Enter Pin" name="pin1" id="a"  maxlength="4" ></div><br>
<div style="font-variant: small-caps; color:white; margin-top: 10px;"> <b>confirm UPI pin  :<input type="number" placeholder="confirm Pin" id="b" name="pin2" maxlength="4" ></div><br>
<div style="font-variant: small-caps; color:white;">Account Name   :  <span><%= session.getAttribute("name")%></span></div><br>
<div><button style="padding:10px 30px; border:none; background:orange; font-size: 15px; color:white;cursor: pointer;" >Update</button></div>

</form>

</div>

</div>


<script >
 var a=parseInt(document.getElementById('a').value);
 var b= parseInt(document.getElementById('b').value);
 function update(){
	 if(a!=b){
		 document.getElementById("msg").innerHTML='Pin Not Macthing';
	  console.log(a);
	 }
 }
</script>
<%} else{%><% response.sendRedirect("login.jsp"); %><%} %>
</body>
</html> 