<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"  href="register.css">
<title>Account View</title>
</head>
<body>
<%if(session.getAttribute("name")!=null){ %>
<div class="nav">
<div class="nav1">
<img alt="Bank Logo" src="banklogo.png" width=40px>
<h1>Pr<span style="color:green; font-family: cursive;">ak</span>ruthi Bank  </h1>

</div>
<div >

<ul class="nav2">
<a href="Account.jsp"><li id="ac">Account View</li></a>


<a href="Welcome.jsp"><li id="ac">back</li></a>
</ul>
</div>
</div>
<div class="secw" style="display: flex; justify-content: center;">
<div class="boxw" style="width:400px; hight:300px; border:1px solid black; background:green; margin-top:50px;padding:30px; border-radius: 10px;">
<div class="menu" style="display: flex; justify-content:space-between;align-items: center; margin-bottom: 15px;">
<div style="color:white; font-size:20px; font-family:fantasy;letter-spacing: 3px;">SBA</div>
<div><button style="padding-left:10px;padding:10px; border:none; background: white; font-size: 13px;cursor: pointer;" >Details</button> </div>
<form action="MiniStatement" method="post" >

<div><button style="padding-left:10px; padding:10px;background: white; border:none;font-size: 13px;cursor: pointer;">Mini Statement</button> </a></div>
</div></form>
<hr>
<div style="font-variant: small-caps; color:white; margin-top: 10px;"> <b>CUSTOMER ID   :<span><%=session.getAttribute("uid") %></span></b></div><br>
<div style="font-variant: small-caps; color:white;">Account Name   :  <span><%= session.getAttribute("name")%></span></div><br>
<div style="font-variant: small-caps; color:white;" >Bank Name        :  <span>Prakruthi Bank</span></div><br>
<div style="font-variant: small-caps; color:white;" >Branch        :  <span>358</span></div><br>
<div style="font-variant: small-caps; color:white;">Account Number  :  <span><%=session.getAttribute("AcNo") %></span></div><br>
<div style="font-variant: small-caps; color:white;">Account Balance  :  <span><%= session.getAttribute("bal")%> &#8377</span></div><br>

</div>

</div>
</div>
<%} else{%><% response.sendRedirect("login.jsp"); %><%} %>
</body>
</html>