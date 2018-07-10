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
    	Doctor doc = new Doctor();
    	Connection connection = null;
    	CallableStatement cs = null;
    	ResultSet rs = null;
    	
    	try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_doctorGetAllData(?)}");
			cs.setInt(1, doctorID);
			rs = cs.executeQuery();
			
			while(rs.next()) {
				doc.setDoctorID(rs.getInt(1));
				doc.setStaffID(rs.getInt(2));
				doc.setStaffName(rs.getString(3));
				doc.setStaffGender(rs.getString(4));
				doc.setPositionID(rs.getInt(5));
				doc.setStaffPosition(rs.getString(6));
				doc.setDoctorTypeID(rs.getInt(7));
				doc.setDoctorType(rs.getString(8));
				doc.setClinicName(rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
    	
    	return doc;
    }

}
