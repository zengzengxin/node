import java.sql.*;

import javax.swing.JOptionPane;


public class db {
	
	protected static String dbClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL数据库引擎
	protected static String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=book123";// 数据源
	protected static String dbUser = "kdbc";
	protected static String dbPwd = "123456";
	protected static String second = null;
	public static Connection conn = null;
      //获取连接
	  public static Connection getconnection(){
		  try {
				if (conn == null) {
					Class.forName(dbClassName); // 创造一个“com.microsoft.sqlserver.jdbc.SQLServerDriver”的对象，并且向数据库注册，告知数据库连接
					conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);// 连接数据库，并且把权力给conn
					System.out.println("数据库链接成功");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,
						"请将SQLServer JDBC4.0以上的驱动包复制到lib文件夹中。");
				System.exit(-1);
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return conn;
	  }
	  
	  //获取stmt
	  public static Statement getstmt(Connection conn){
		  Statement stmt =null;
		  try{
			  if(conn != null){
				  stmt = conn.createStatement();
			  }
		  }catch(SQLException e){
			  System.out.println("执行获取表达式语句过程中出现了错误。。。");
	          e.printStackTrace(); 
		  }
		return stmt;
		  
	  }
	  
	  
	 //获取查询结果集
	  public  static ResultSet getrusultset(Statement stmt,String sql){
		  ResultSet rs = null;
		  try{
			  if(stmt != null){
				  rs = stmt.executeQuery( sql);
			  }
		  }catch (SQLException e) {
	            System.out.println("执行查询过程中出现了错误。。。");
	            e.printStackTrace();
	        }
		  return rs;		  
	  } 
	  
	  // 关闭表达式语句
	    public static void close(Statement stmt) {
	        try {
	            if (stmt != null) {
	                stmt.close();
	                stmt = null;
	            }
	        } catch (SQLException e) {
	            System.out.println("执行关闭表达式语句过程中出现了错误。。。");
	            e.printStackTrace();
	        }        
	    }
	    
	    // 关闭结果集
	    public static void closers(ResultSet rs) {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	        } catch (SQLException e) {
	            System.out.println("执行关闭结果集过程中出现了错误。。。");
	            e.printStackTrace();
	        }        
	    }
	    // 关闭连接
	    public static void closeconn(Connection conn) {
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            System.out.println("执行关闭数据库连接过程中出现了错误。。。");
	            e.printStackTrace();
	        }        
	    }
	    
	    // 关闭表达式语句
	    public static void closestmt(Statement stmt) {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	        } catch (SQLException e) {
	            System.out.println("执行关闭表达式语句过程中出现了错误。。。");
	            e.printStackTrace();
	        }        
	    }
}
