import java.sql.*;

import javax.swing.JOptionPane;


public class db {
	
	protected static String dbClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL���ݿ�����
	protected static String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=book123";// ����Դ
	protected static String dbUser = "kdbc";
	protected static String dbPwd = "123456";
	protected static String second = null;
	public static Connection conn = null;
      //��ȡ����
	  public static Connection getconnection(){
		  try {
				if (conn == null) {
					Class.forName(dbClassName); // ����һ����com.microsoft.sqlserver.jdbc.SQLServerDriver���Ķ��󣬲��������ݿ�ע�ᣬ��֪���ݿ�����
					conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);// �������ݿ⣬���Ұ�Ȩ����conn
					System.out.println("���ݿ����ӳɹ�");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,
						"�뽫SQLServer JDBC4.0���ϵ����������Ƶ�lib�ļ����С�");
				System.exit(-1);
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return conn;
	  }
	  
	  //��ȡstmt
	  public static Statement getstmt(Connection conn){
		  Statement stmt =null;
		  try{
			  if(conn != null){
				  stmt = conn.createStatement();
			  }
		  }catch(SQLException e){
			  System.out.println("ִ�л�ȡ���ʽ�������г����˴��󡣡���");
	          e.printStackTrace(); 
		  }
		return stmt;
		  
	  }
	  
	  
	 //��ȡ��ѯ�����
	  public  static ResultSet getrusultset(Statement stmt,String sql){
		  ResultSet rs = null;
		  try{
			  if(stmt != null){
				  rs = stmt.executeQuery( sql);
			  }
		  }catch (SQLException e) {
	            System.out.println("ִ�в�ѯ�����г����˴��󡣡���");
	            e.printStackTrace();
	        }
		  return rs;		  
	  } 
	  
	  // �رձ��ʽ���
	    public static void close(Statement stmt) {
	        try {
	            if (stmt != null) {
	                stmt.close();
	                stmt = null;
	            }
	        } catch (SQLException e) {
	            System.out.println("ִ�йرձ��ʽ�������г����˴��󡣡���");
	            e.printStackTrace();
	        }        
	    }
	    
	    // �رս����
	    public static void closers(ResultSet rs) {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	        } catch (SQLException e) {
	            System.out.println("ִ�йرս���������г����˴��󡣡���");
	            e.printStackTrace();
	        }        
	    }
	    // �ر�����
	    public static void closeconn(Connection conn) {
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            System.out.println("ִ�йر����ݿ����ӹ����г����˴��󡣡���");
	            e.printStackTrace();
	        }        
	    }
	    
	    // �رձ��ʽ���
	    public static void closestmt(Statement stmt) {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	        } catch (SQLException e) {
	            System.out.println("ִ�йرձ��ʽ�������г����˴��󡣡���");
	            e.printStackTrace();
	        }        
	    }
}
