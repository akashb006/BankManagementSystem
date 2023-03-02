package com.prakruthi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Transaction
 */
@WebServlet("/Transaction")
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setAttribute("msg",null);

		String name= session.getAttribute("name").toString();
		Date d1= new Date();
		String d2=d1.toLocaleString();
		String date="";
		String acno=session.getAttribute("AcNo").toString();
		String mobileno= session.getAttribute("mobileno").toString();
		String uid=session.getAttribute("uid").toString();
		double balance=Double.parseDouble(session.getAttribute("bal").toString());
		int pin2=Integer.parseInt(session.getAttribute("pin").toString());
		String ifsc="PKR0358";
		double deposit=0;
		double withdraw=0;
		double transfer=0;
		//----------------------------------------------------------------------date
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle123","scott", "tiger");
			String date1= "select sysdate from dual";
			PreparedStatement ps3=con.prepareStatement(date1);
			ResultSet rs=ps3.executeQuery();
			if(rs.next()) {
				date=rs.getString("sysdate");
				session.setAttribute("date", date);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//--------------------------------------------------------------------------------

		//pin validation 
		String mno="";
		int pin=0;
		if(request.getParameter("deposit")!=null) {
			deposit=Double.parseDouble(request.getParameter("deposit"));
		}
		if(request.getParameter("withdraw")!=null) {
			withdraw=Double.parseDouble(request.getParameter("withdraw"));
		}
		if(request.getParameter("transfer")!=null) {
			pin= Integer.parseInt(request.getParameter("pin"));
			transfer =Double.parseDouble(request.getParameter("transfer"));
			mno=request.getParameter("uid");
		}
		double updatedBal=0;
		String type="";
		double amt=0;
		Account a1= new Account(name, mobileno, acno,ifsc , balance, pin2);
		if(deposit>0) {
			type="Credited";
			amt=deposit;
			updatedBal=a1.deposit(deposit);
		}
		if(withdraw>0) {
			type="Debited";
			amt=withdraw;
			updatedBal=a1.withdraw(withdraw);
		}
		if(transfer>0) {

			if(a1.transfer(mno, pin)!=null) {
				type="Debited";
				amt=transfer;
				updatedBal=a1.withdraw(transfer);
				if(updatedBal==0) {
					session.setAttribute("date", d2);
					String error="Transaction Failed";
					session.setAttribute("error", error);
					session.setAttribute("type", "insufficient fund");
					session.setAttribute("amt", balance);
					RequestDispatcher rd=request.getRequestDispatcher("Transaction.jsp");
					rd.forward(request, response);

				}else {
					try {
						Class.forName("oracle.jdbc.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle123","scott", "tiger");
						//updation to reciever account
						String upadate="update prakruthi set bal=bal+"+amt+" where mobileno='"+mno+"'";
						Statement ps1=con.createStatement();
						int row1=ps1.executeUpdate(upadate);
						//extract previous bal of reciever
						String getbal="select userid, bal from prakruthi where mobileno='"+mno+"'";
						Statement ps3=con.createStatement();
						ResultSet rs=ps3.executeQuery(getbal);
						double balr=0;
						String uid2="";
						if(rs.next()) {
							uid2=rs.getString("userid");
							balr=rs.getDouble("bal");
						}
						String hash=""+a1.hashCode();
						String tid=date.substring(0,4)+date.substring(5,7)+date.substring(8,10)+"00"+hash.substring(0,4);
						//insert into reciever account passbook
						String passbookupdate="insert into "+uid2+" values('"+tid+"',sysdate, 'Credited' ,"+amt+ ","+balr+")";
						PreparedStatement ps2=con.prepareStatement(passbookupdate);

						int row2=ps2.executeUpdate();

					}catch(SQLException e1) {
						e1.printStackTrace();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
				}
			}else {
				session.setAttribute("date", d2);
				String error="Transaction Failed";
				session.setAttribute("error", error);
				session.setAttribute("type", "Invalid Pin!!");
		
				RequestDispatcher rd=request.getRequestDispatcher("Transaction.jsp");
				rd.forward(request, response);
			}
		}

		if(updatedBal==0) {
			session.setAttribute("date", d2);
			String error="Transaction Failed";
			session.setAttribute("error", error);
			session.setAttribute("type", "insufficient fund");
			session.setAttribute("amt", amt);
			RequestDispatcher rd=request.getRequestDispatcher("Transaction.jsp");
			rd.forward(request, response);

		}else {


			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle123","scott", "tiger");
				String upadate="update prakruthi set bal="+updatedBal+" where userid='"+uid+"'";
				Statement ps1=con.createStatement();
				int row1=ps1.executeUpdate(upadate);
				String hs=""+a1.hashCode();
				String tid=date.substring(0,4)+date.substring(5,7)+date.substring(8,10)+"00"+hs.substring(0,4);
				String passbookupdate="insert into "+uid+" values('"+tid+"', sysdate, '"+type+"' ,"+amt+ ","+updatedBal+")";
				PreparedStatement ps2=con.prepareStatement(passbookupdate);

				int row2=ps2.executeUpdate();
				String count="select  * from "+uid+"";
				PreparedStatement ps4=con.prepareStatement(count);
				ResultSet rs2=ps4.executeQuery();
				ResultSetMetaData resuk=rs2.getMetaData();

				if(rs2.next()) {

					int count2=  resuk.getColumnCount();
					session.setAttribute("count", count2);
				}
				if(row1>0 && row2>0) {
					String msg="Transaction successful!!";
					session.setAttribute("date", d2);
					session.setAttribute("msg", msg);
					session.setAttribute("bal", updatedBal);
					session.setAttribute("type", type);
					session.setAttribute("amt", amt);
					session.setAttribute("id", tid);
					RequestDispatcher rd=request.getRequestDispatcher("Transaction.jsp");
					rd.forward(request, response);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e1) {
				e1.printStackTrace();;
			}
		}
	}

}

