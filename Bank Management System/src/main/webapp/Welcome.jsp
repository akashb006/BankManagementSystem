<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"  href="register.css">
<title><%= session.getAttribute("name") %></title>
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
<a href="Logout"><li id="ac">Logout</li></a>
<a href="Account.jsp"><li id="ac">Account view<select>
<option>Savings Account</option>
<option>Salary Account</option>
<option>Current Account</option>
</select></li></a>

<a href="update.jsp"><li id="ac">Update Details</li></a>
<a href="https://mail.google.com/mail/u/0/#search/akashyadav15931593%40gmail.com?compose=new"><li id="ac">Contact Us</li></a>
</ul>
</div>
</div>
<marquee direction="left" loop="10"><h2 style="text-align: center; margin-top:20px; color:green;"> Welcome  <b> <%= session.getAttribute("name") %></b></h2></marquee>
<div class="secw" style="display: flex; justify-content: center;">
<div class="boxw" style="width:400px; hight:300px; border:1px solid black; background:#fffff2; margin-top:50px;padding:30px; border-radius: 10px;">
<div class="boxw1">
<h6 style="color:black; font-size: 20px;padding:10px;background:skyblue; " ><b>CheckBalance </b></h6>
<h6 style="color:black; font-size: 20px;padding:10px;margin-top:20px; " ><b><%=session.getAttribute("name") %></b></h6>
<h6 style="color:black; font-size: 13px;margin-top:20px; " ><b>A/C No:<%= session.getAttribute("AcNo") %> </b></h6>

<img alt="" src="">
</div>
<div class="boxw1"  style="color:black; display:flex;justify-content:space-between; margin-top:20px; align-items: center;">
<b><p id="bal"  style="color:black;">XXXXX.X  &#8377</p><span id="bal2"  style="color:black;"></span></b>
<button onclick="bal()"><h6 style="color:white; background-color:green; padding:5px 10px;font-size:13px; border-radius:5px; border:none;cursor: pointer;">checkbalance</h6></button>
<img alt="Bank Logo" src="banklogo.png" width=40px>
</div>
</div>

</div>
</div>
<form action="Transaction" method="post">
<div class="secw" style="display: flex; justify-content: center;">
<div class="boxw" style="width:400px; hight:300px; border:1px solid black; background:#fffff2; margin-top:50px;padding:30px; border-radius: 10px;">
<div class="boxw1">
<h6 style="color:black; font-size: 20px;padding:10px;background:skyblue; " ><b>Deposit Amount here </b></h6>

<img alt="" src="">
</div>
<div class="boxw1"  style="color:black; display:flex;justify-content:space-between; margin-top:20px; align-items: center;">
<b><input type="number" placeholder="XXXXX.X"  name="deposit" required><span id="bal2"  style="color:black;"></span></b>
<button onclick="deposit()"><h6 style="color:white; font-size:13px; padding:5px 10px; border-radius:5px; background: green;cursor: pointer;">Deposit</h6></button>
<img alt="Bank Logo" src="banklogo.png" width=40px>
</div>
</div>

</div>
</div>
</form>
<form action="Transaction" method="post">
<div class="secw" style="display: flex; justify-content: center;">
<div class="boxw" style="width:400px; hight:300px; border:1px solid black; background:#fffff2; margin-top:50px;padding:30px; border-radius: 10px;">
<div class="boxw1">
<h6 style="color:black; font-size: 20px;padding:10px;background:skyblue; " ><b>Withdraw Amount here </b></h6>

<img alt="" src="">
</div>
<div class="boxw1"  style="color:black; display:flex;justify-content:space-between; margin-top:20px; align-items: center;">
<b><input type="number" placeholder="XXXXX.X"  name="withdraw" required><span id="bal2"  style="color:black;"></span></b>
<button type="submit"><h6 style="color:white;  padding:5px; border-radius:5px; background: green; font-size:13px; cursor: pointer;">Withdraw</h6></button>
<img alt="Bank Logo" src="banklogo.png" width=40px>
</div>
</div>

</div>
</div>
</form>
<form action="Transaction" method="post">
<div class="secw" style="display: flex; justify-content: center;">
<div class="boxw" style="width:400px; hight:300px; border:1px solid black; background:#fffff2; margin-top:50px;padding:30px; border-radius: 10px;">
<div class="boxw1">
<h6 style="color:black; font-size: 20px;padding:10px;background:skyblue; " ><b>Transfer Amount Here </b></h6>

<img alt="" src="">
</div>
<div class="boxw1"  style="color:black;  margin-top:20px; align-items: center;">
<b>Enter receiver mobile Number:<br><input type="number" placeholder="Enter mobile number"  name="uid" required><span id="bal2"  style="color:black;"></span></b><br><br>
<b>Enter UPI pin: <br><input type="number" placeholder="Enter Pin"  name="pin" required><span id="bal2"  style="color:black;"></span></b><br><br>
<b>Enter Amount:<br><input type="number" placeholder="XXXXX.X"  name="transfer" required><span id="bal2"  style="color:black;"></span></b><br><br>
<div style="display:flex;justify-content:space-between;align-items:center;">
<button type="submit"><h6 style="color:white;  padding:5px 20px; border-radius:3px; background: green;cursor: pointer;">Pay</h6></button>
<img alt="Bank Logo" src="banklogo.png" width=40px>
</div>
</div>
</div>

</div>
</div>
</form>
<script>
function bal(){
 document.getElementById("bal").innerHTML= <%= session.getAttribute("bal") %> + ' '+'&#8377';
 
}
</script>
<%} else{%><%response.sendRedirect("login.jsp"); %><%} %>
</body>
</html>