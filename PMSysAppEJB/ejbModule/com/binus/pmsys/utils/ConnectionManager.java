package com.binus.pmsys.utils;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionManager {
static DataSource ds = null;
	
	public static Connection getConnection(String jdbcName)
	{
		Connection con = null;
		try
		{
			Context ctx = new InitialContext();
			
			if(ds == null)
			{
				ds = (DataSource) ctx.lookup(jdbcName);
			}
				try
				{
					con = ds.getConnection();
				} catch (Exception e) {
					e.printStackTrace();
				}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
