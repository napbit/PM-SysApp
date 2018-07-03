package com.binus.pmsys.eao;

import java.sql.CallableStatement;
import java.sql.Connection;

import javax.ejb.Stateless;

import com.binus.pmsys.entity.NewPatient;
import com.binus.pmsys.utils.ReleaseConnection;
import com.binus.pmsys.utils.Settings;

@Stateless
public class RegistrationEao {

	public RegistrationEao() { }
	
	public void savePatient(NewPatient patientData) {
		Connection connection = null;
		CallableStatement cs = null;
		
    	try {
    		connection = Settings.getConnection();
    		cs = connection.prepareCall("{call sp_patientInsert(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, patientData.getPatientKTP());
			cs.setString(2, patientData.getPatientName());
			cs.setString(3, patientData.getPatientGender());
			cs.setString(4, patientData.getPatientDOB());
			cs.setString(5, patientData.getPatientBPJS());
			cs.setInt(6, patientData.getPatientBPJSTypeID());
			cs.setString(7, patientData.getPhoneNumber());
			cs.setInt(8, patientData.getPhoneTypeID());
			cs.setString(9, patientData.getContactName());
			cs.setString(10, patientData.getContactRelationship());
			cs.setString(11, patientData.getContactNumber());
			cs.setInt(12, patientData.getProvinceID());
			cs.setInt(13, patientData.getKabupatenID());
			cs.setString(14, patientData.getAddress());
			cs.setString(15, patientData.getPostCode());
			cs.execute();
    	} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs);
		}
    }
	
}
