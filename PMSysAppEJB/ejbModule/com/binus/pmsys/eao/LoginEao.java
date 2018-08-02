package com.binus.pmsys.eao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.ejb.Stateless;

import com.binus.pmsys.utils.ReleaseConnection;
import com.binus.pmsys.utils.Settings;

/**
 * Session Bean implementation class LoginEao
 */
@Stateless
public class LoginEao {

    /**
     * Default constructor. 
     */
    public LoginEao() {
    	
    }
    
    public int getTotalStaff() {
    	int total = 0;
    	Connection connection = null;
    	CallableStatement cs = null;
    	ResultSet rs = null;
    	
    	try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_totalStaff()}");
			rs = cs.executeQuery();
			
			while(rs.next()) {
				total = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
    	
    	return total;
    }
    
    public int getTotalPatients() {
    	int total = 0;
    	Connection connection = null;
    	CallableStatement cs = null;
    	ResultSet rs = null;
    	
    	try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_totalPatient()}");
			rs = cs.executeQuery();
			
			while(rs.next()) {
				total = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
    	
    	return total;
    }
    
    public int getTotalMedicines() {
    	int total = 0;
    	Connection connection = null;
    	CallableStatement cs = null;
    	ResultSet rs = null;
    	
    	try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_totalMedicine()}");
			rs = cs.executeQuery();
			
			while(rs.next()) {
				total = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
    	
    	return total;
    }
}
