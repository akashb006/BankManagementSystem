package com.prakruthi;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import jakarta.*;
import jakarta.servlet.http.*;
import jakarta.servlet.*;


/**
 * Servlet implementation class OpenServlet
 */

public class OpenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");

		String adhar=request.getParameter("adhar");
		String pan=request.getParameter("pan");
		String mobileno=request.getParameter("mobile");
		String Ad=request.getParameter("adress");
		String fname=request.getParameter("fname");
		String mname=request.getParameter("mname");
		String uid="PKR"+adhar.substring(0, 5);
		String AcNo=358+adhar.substring(3,9)+mobileno.substring(0,3);
		double bal=500.00;
		int pin=Integer.parseInt(adhar.substring(3,7));
		PrintWriter out= response.getWriter();

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle123","scott", "tiger");
			String str="insert into Prakruthi values('"+uid+"','"+AcNo+"', '"+name+"', '"+adhar+"','"+pan+"','"+mobileno+"','"+Ad+"','"+fname+"','"+mname+"',"+bal+","+pin+")";
			PreparedStatement st = con.prepareStatement(str);
			int row= st.executeUpdate();
			String str2="create table "+uid+" (Transaction_Id varchar(30), tdate date, transaction_type varchar(15), amt number(15,3), bal number(15,3))";
			PreparedStatement st2 = con.prepareStatement(str2);
			int row2= st2.executeUpdate();
			if(row>0 ) {
				HttpSession session= request.getSession();
				session.setAttribute("name", name);
				out.print("<b>Registration Successful!!<br> <br>Thank You For Registering!!<br> Login uisng below creditionals<b><br><br>" +"Your User Id: "+uid +"<br><br> Password:"+mobileno +"<br><br>upi Pin:"+pin);

			}else {
				out.print("<b>Error Occured<b>");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e1) {
			e1.printStackTrace();
		}

	}

}
