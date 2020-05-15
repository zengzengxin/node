import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class showrsusebean extends HttpServlet {

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>student</title>");
		pw.println("</head>");
		pw.println("<body bgcolor='#FDF5E6'>");
		pw.println("<table border='1' align='center'>");
		pw.println("<tr><td>book1Name:</td></tr>");

		Connection conn = db.getconnection();
		System.out.println("数据库连接成功");
		java.sql.Statement stmt = db.getstmt(conn);
		ResultSet rs = db.getrusultset(stmt, "select * from student");
		try {
			while (rs.next()) {
				pw.println("<tr>");
				pw.println("<td>" + rs.getString("sname") + "</td>");
				pw.println("</tr>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeconn(conn);
			db.close(stmt);
			db.closers(rs);
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}