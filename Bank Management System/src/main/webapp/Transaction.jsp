<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"  href="register.css">
<title>Transaction</title>
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
<a href="Account.jsp"><li id="ac">Account View</li></a>


<a href="Welcome.jsp"><li id="ac">back</li></a>
</ul>
</div>
</div>
 
<div style="display: flex; justify-content: center;;">
<div style="width:400px;height: 300px;border:1px solid green; box-shadow:10px 12px 10px; margin-top: 30px;">
<% if(session.getAttribute("msg")!=null){ %><h4 style="color:white;text-align: center; background: green;padding:10px;"><%= session.getAttribute("msg")%></h4><%} else {%><h4 style="color:white;background: red; text-align: center;padding: 10px;"><%=session.getAttribute("error") %></h4><%} %>
<div style="color:black;margin-left: 10px;">
<h4><%=session.getAttribute("name") %></h4>
<h4><%=session.getAttribute("mobileno") %></h4>
<h6 style="color:grey;"><%=session.getAttribute("date") %></h6>
</div>
<hr>
<div style="text-align: center;margin-top: 50px;">
<h4>Transaction Id: <%=session.getAttribute("id") %></h4>
<h3 id="dsp" onshow="dsp()"><%= session.getAttribute("type") %></h3>
<h1 style="display:flex;align-items:center; justify-content: center; margin-top: 15px;"><span>&#8377</span><%= session.getAttribute("amt") %><% if(session.getAttribute("type")=="Credited" || session.getAttribute("type")=="Debited"){ %>
<img alt="" src="download.png"  width="40px" id="pht"></h1><%} else { %>
<img alt="" src="ak3.png"  width="40px" id="pht"></h1> <% }%>
</div>
</div>
</div>

<%} else{%><%response.sendRedirect("login.jsp"); %><%} %>
</body>
</html>