package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {
	
	public static void close(ResultSet rs, Statement stm)
	{
		if (rs != null) {
			try {
				rs.close();
			}
			catch (Exception e) { }
		}
		
		if (stm != null) {
			try {
				stm.close();
			}
			catch (Exception e) { }
		}
	}
	
	public static void close(ResultSet rs, Statement stm, Connection conn)
	{
		if (rs != null) {
			try {
				rs.close();
			}
			catch (Exception e) { }
		}
		
		if (stm != null) {
			try {
				stm.close();
			}
			catch (Exception e) { }
		}
		
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) { }
		}
	}
	
	public static void close(PreparedStatement ps, Connection conn)
	{
		if (ps != null) {
			try {
				ps.close();
			}
			catch (Exception e) { }
		}
		
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) { }
		}
	}
	
	public static void close(ResultSet rs)
	{
		if (rs != null) {
			try {
				rs.close();
			}
			catch (Exception e) { }
		}
	}

	public static void close(Statement stm)
	{
		if (stm != null) {
			try {
				stm.close();
			}
			catch (SQLException e) { }
		}
	}
	
	public static void close(Connection conn)
	{
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) { }
		}
	}
}
