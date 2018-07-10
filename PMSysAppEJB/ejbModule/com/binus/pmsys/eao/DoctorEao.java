package com.binus.pmsys.eao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.binus.pmsys.entity.Doctor;
import com.binus.pmsys.utils.ReleaseConnection;
import com.binus.pmsys.utils.Settings;

/**
 * Session Bean implementation class DoctorEao
 */
@Stateless
@LocalBean
public class DoctorEao {

    /**
     * Default constructor. 
     */
    public DoctorEao() {
        // TODO Auto-generated constructor stub
    }
    
    public Doctor getDoctorAllData(int doctorID) {
    	Doctor doctor = new Doctor();
    	Connection connection = null;
    	CallableStatement cs = null;
    	ResultSet rs = null;
    	
    	try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_}");
			cs.setInt(1, doctorID);
			rs = cs.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
    	
    	
    	return doctor;
    }

}
