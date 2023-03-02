package com.prakruthi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

/**
 * Servlet implementation class UpdateMob
 */
@WebServlet("/UpdateMob")
public class UpdateMob extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setAttribute("msgup2", null);
		String mobno1= request.getParameter("mobno1");
		String mobno2= request.getParameter("mobno2");
		String mno= session.getAttribute("mobileno").toString();
		String msgup2="";
		if(mobno1.equals(mobno2)) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle123","scott", "tiger");
				// pin updation 
				String upadate="update prakruthi set mobileno="+mobno1+" where mobileno='"+mno+"'";
				Statement ps1=con.createStatement();
				int row1=ps1.executeUpdate(upadate);
				msgup2="<p style=\"color:green; text-align:center;\">"+mobno1+" Mobile Number Updation Succefull!!<p>";
				session.setAttribute("upmob", mobno1);
				session.setAttribute("msgup2", msgup2);
				RequestDispatcher rd= request.getRequestDispatcher("updateMobileno.jsp");
				rd.forward(request, response);
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}else {
			msgup2="<p style=\"color:red; text-align:center;\"> Number Miss Matching!!  Mobile Number Updation Failed!!<p>";

			session.setAttribute("msgup2", msgup2);
			RequestDispatcher rd= request.getRequestDispatcher("updateMobileno.jsp");
			rd.forward(request, response);
		}
	}

}
