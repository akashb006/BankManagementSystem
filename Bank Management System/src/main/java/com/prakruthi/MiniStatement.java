package com.prakruthi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MiniStatement
 */
@WebServlet("/MiniStatement")
public class MiniStatement extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		String str =(String) session.getAttribute("uid");


		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle123","scott", "tiger");

			String count2="select TRANSACTION_ID,TDATE,TRANSACTION_TYPE,amt, bal from "+str+" order by TDATE desc";
			Statement ps5=con.prepareStatement(count2);
			ResultSet rs3=ps5.executeQuery(count2);
			String str2=
					"<!DOCTYPE html>\r\n"
							+ "<html lang=\"en\">\r\n"
							+ "<head>\r\n"
							+ "    <meta charset=\"UTF-8\">\r\n"
							+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
							+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n  <link rel=\"stylesheet\"  href=\"register.css\">"
							+ "    <title>"+str+"</title>\r\n"
							+ "    <style>\r\n"
							+ "        table{\r\n"
							+ "            text-align: center;\r\n font-family: sans-serif;"

				   		+ "            row-gap: 10px;\r\n"
				   		+ "            border: 1px solid purple;\r\n"
				   		+ "            \r\n"
				   		+ "            \r\n"
				   		+ "        }\r\n"
				   		+ "       th{\r\n"
				   		+ "            margin-left: 0px;\r\n"
				   		+ "            background-color: purple;\r\n"
				   		+ "            color: white;\r\n"
				   		+ "          \r\n"
				   		+ "            padding: 0px 40px;\r\n"
				   		+ "            \r\n"
				   		+ "        }\r\n"
				   		+ "        tr{\r\n"
				   		+ "            padding: 20px;\r\n"
				   		+ "            border: 1px solid purple;\r\n"
				   		+ "            \r\n"
				   		+ "            \r\n"
				   		+ "        }\r\n"
				   		+ "    </style>\r\n"
				   		+ "</head>\r\n"
				   		+ "<body>\r\n  <div class=\"nav\">\r\n"
				   		+ "<div class=\"nav1\">\r\n"
				   		+ "<img alt=\"Bank Logo\" src=\"banklogo.png\" width=40px>\r\n"
				   		+ "<h1>Pr<span style=\"color:green; font-family: cursive;\">ak</span>ruthi Bank  </h1>\r\n"
				   		+ "\r\n"
				   		+ "</div>\r\n"
				   		+ "<div >\r\n"
				   		+ "\r\n"
				   		+ "<ul class=\"nav2\">\r\n"
				   		+ "<a href=\"Account.jsp\"><li id=\"ac\">back</li></a>\r\n"
				   		+ "\r\n"
				   		+ "\r\n"
				   		+ "<button onclick=\"print()\" style=\"background-color: red; color: white; border:none;cursor: pointer; font-size: 16px;\"><li id=\"ac\">Print</li></button>\r\n"
				   		+ "</ul>\r\n"
				   		+ "</div>\r\n"
				   		+ "</div>"

				   		+ "   <center> <table>\r\n"
				   		+ "        <tr>\r\n"
				   		+ "            <th>TRANSACTION_ID</th>\r\n"
				   		+ "            <th>DATE</th>\r\n"
				   		+ "            <th>TRANSACTION TYPE</th>\r\n"
				   		+ "            <th>AMOUNT</th>\r\n"
				   		+ "            <th>BALANCE</th>\r\n"
				   		+ "\r\n"
				   		+ "        </tr>\r\n";
			out.print(str2);

			while(rs3.next()) {
				String type=rs3.getString("TRANSACTION_TYPE");
				String str3= "        <div id=\"data\">\r\n"
						+ "        <tr >\r\n"
						+ "            <td>"+rs3.getString("TRANSACTION_ID")+"</td>\r\n"
						+ "            <td>"+rs3.getString("TDATE")+"</td>\r\n";
				String str31="";

				if(type.equals("Credited")) {
					str31= "            <td style=\"color: green;\">"+rs3.getString("TRANSACTION_TYPE")+"</td>\r\n"
							+ "            <td style=\"color: green;\">+"+rs3.getString("amt")+".00 &#8377</td>\r\n";
				}else {
					str31= "            <td style=\"color:red;\">"+rs3.getString("TRANSACTION_TYPE")+"</td>\r\n"
							+ "            <td style=\"color:red;\">-"+rs3.getString("amt")+".00 &#8377</td>\r\n";
				}
				String str32= "            <td style=\"color: green;\">"+rs3.getString("bal")+".00 &#8377</td>\r\n"
						+ "        </tr>\r\n"
						+ "        </div>\r\n";
				out.print(str3);
				out.print(str31);
				out.print(str32);


			}


			String str4= "    </table></center>\r\n"
					+ "    <script >\r\n"
					+ "    var n= <%=session.getAttribute(\"count\")%>;\r\n"
					+ "      for()\r\n"
					+ "    </script>\r\n"
					+ "</body>\r\n"
					+ "</html>";


			out.print(str4);







		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
