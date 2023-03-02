package com.prakruthi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Forgot
 */
@WebServlet("/Forgot")
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phoneno=request.getParameter("phno");
		PrintWriter out=response.getWriter();
		
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try{
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle123", "scott", "tiger");
			String uid = null;
			Statement st =con.createStatement();
			ResultSet res=st.executeQuery("select userid from prakruthi where mobileno="+phoneno);
			while(res.next()) {
				 uid= res.getString("userid");
				
			}
			if(uid==null) {
				out.print("<b style='color:red'>User Not Exsist for This No<b>");
			}else {
				out.println("<b>"+uid+"<b>");
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
	}

}
