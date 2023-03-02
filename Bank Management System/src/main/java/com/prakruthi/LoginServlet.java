package com.prakruthi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("uid");
		String pwd=request.getParameter("pwd");

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle123","scott","tiger");
			Statement st = con.createStatement();
			ResultSet res= st.executeQuery("select name,pin, acno,bal,mobileno from prakruthi where userid='"+uid+"' and mobileno='"+pwd+"'");
			if(res.next()) {

				String name= res.getString("name");
				String acno= res.getString("acno");
				double bal=Double.parseDouble(res.getString("bal"));
				int pin =res.getInt("pin");

				String mobileno=res.getString("mobileno");
				String ifsc="PKR0358";
				HttpSession session= request.getSession();
				session.setAttribute("msgup1", null);
				session.setAttribute("msgup2", null);
				session.setAttribute("name", name);
				session.setAttribute("pin", pin);
				session.setAttribute("AcNo", acno);
				session.setAttribute("bal", bal);
				session.setAttribute("uid", uid);
				session.setAttribute("mobileno", mobileno);
				RequestDispatcher rd1= request.getRequestDispatcher("/Transaction");
				RequestDispatcher rd= request.getRequestDispatcher("Welcome.jsp");
				rd.forward(request, response);
			}else {
				String msg="Invalid Creditionals";
				HttpSession session=request.getSession();
				session.setAttribute("msg1", msg);

				RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}

}
