package com.binus.pmsys.eao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.ejb.Stateless;

import com.binus.pmsys.utils.ReleaseConnection;

@Stateless
public class RegistrationEao {

	public RegistrationEao() { }
	
	public void getPatients() {
		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
	}
	
}
