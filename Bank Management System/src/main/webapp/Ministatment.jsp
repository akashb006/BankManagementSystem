<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table{
            text-align: center;
            row-gap: 10px;
            border: 1px solid purple;
            
            
        }
       th{
            margin-left: 0px;
            background-color: purple;
            color: white;
          
            padding: 0px 40px;
            
        }
        tr{
            padding: 20px;
            border: 1px solid purple;
            
            
        }
    </style>
</head>
<body>
<h1><%=session.getAttribute("count")%></h1>
   <center> <table>
        <tr>
            <th>DATE</th>
            <th>TRANSACTION_ID</th>
            <th>Transtion_type</th>
            <th>Amount</th>
            <th>Balance</th>

        </tr>
        <div id="data">
        <tr >
            <td>ak</td>
            <td>al</td>
            <td>al</td>
            <td>al</td>
            <td>al</td>
        </tr>
        </div>
    </table></center>
    <script >
    var n= <%=session.getAttribute("count")%>;
      for()
    </script>
</body>
</html>