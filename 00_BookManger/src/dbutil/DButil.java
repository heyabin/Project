package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DButil {
	private Connection con ;
	private Statement sta ;
	private ResultSet rs ;
	public Connection getCon() {
		String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=yun4jbookSY1";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url, "sa", "sa");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public DButil() {
		 try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url ="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=yun4jbookSY1";
			con = DriverManager.getConnection(url, "sa", "sa");
			System.out.println("数据库连接成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int   update(String sql){
		int rows = 0;
		System.out.println(sql);
		try {
			sta = con.createStatement();
			rows  =  sta.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		return rows;
	}
	public int  update(Connection newcon,String sql){
		int rows = 0;
		System.out.println(sql);
		try {
			sta = newcon.createStatement();
			rows  =  sta.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		return rows;
	}
	public ResultSet query(String sql){
		try {
			System.out.println(sql);
			sta = con.createStatement();
			rs = sta.executeQuery(sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public  void close(){
		try {
			if (rs!= null) {
				rs.close();
				rs = null;
			}
			if (sta!= null) {
				sta.close();
				sta = null;
			}
			if (con!= null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
