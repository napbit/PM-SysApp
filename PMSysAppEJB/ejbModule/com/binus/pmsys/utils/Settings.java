package com.binus.pmsys.utils;

import java.sql.Connection;

public class Settings {
	public static Connection getConnection()
	{
		Connection con = null;
		try
		{
		 	con = ConnectionManager.getConnection("jdbc/Adrena");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}

