package com.binus.pmsys.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReleaseConnection
{
	public static void close(Connection connection)
	{
		try
		{
			if(connection != null) connection.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void close(Connection connection, PreparedStatement ps)
	{
		try
		{
			if(ps != null)ps.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		try {
			if(connection != null) connection.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void close(Connection connection, PreparedStatement ps, ResultSet rs)
	{
		try
		{
			if(rs != null)rs.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			if(ps != null)ps.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			if(connection != null)connection.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void close(Connection connection, CallableStatement cs)
	{
		try
		{
			if(cs != null)cs.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		try {
			if(connection != null) connection.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void close(Connection connection, CallableStatement cs, ResultSet rs)
	{
		try
		{
			if(rs != null)rs.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			if(cs != null)cs.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			if(connection != null)connection.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
