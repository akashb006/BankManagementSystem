package com.prakruthi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setAttribute("msgup1", null);
		int pin1= Integer.parseInt(request.getParameter("pin1"));
		int pin2= Integer.parseInt(request.getParameter("pin2"));
		String mno= session.getAttribute("mobileno").toString();
		String msgup1="";
		if(pin1==pin2) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle123","scott", "tiger");
				// pin updation 
				String upadate="update prakruthi set pin="+pin1+" where mobileno='"+mno+"'";
				Statement ps1=con.createStatement();
				int row1=ps1.executeUpdate(upadate);
				msgup1="<p style=\"color:green; text-align:center;\">Pin Updation Succefull!!<p>";
				session.setAttribute("update", pin1);
				session.setAttribute("msgup1", msgup1);
				RequestDispatcher rd= request.getRequestDispatcher("update.jsp");
				rd.forward(request, response);
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}else {
			msgup1="<p style=\"color:red; text-align:center;\">Pin Miss Matching!!  Pin Updation Failed!!<p>";

			session.setAttribute("msgup1", msgup1);
			RequestDispatcher rd= request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
		}
	}

}
