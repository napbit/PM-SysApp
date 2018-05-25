package com.binus.pmsys.eao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.binus.pmsys.entity.Patient;
import com.binus.pmsys.utils.ReleaseConnection;
import com.binus.pmsys.utils.Settings;

@Stateless
public class RegistrationEao {

	public RegistrationEao() { }
	
	public void savePatient(Patient patientData) {
		Connection connection = null;
		CallableStatement cs = null;
		
    	try {
    		connection = Settings.getConnection();
    		cs = connection.prepareCall("{call sp_percobaan_insert_patient(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, patientData.getPatientKTP());
			cs.setString(2, patientData.getName());
			cs.setString(3, patientData.getGender());
			cs.setString(4, patientData.getBirthDate());
			cs.setString(5, patientData.getPatientBPJS());
			cs.setString(6, patientData.getAddress().getNoHP());
			cs.setString(7, patientData.getAddress().getNoTel());
			cs.setString(8, patientData.getAddress().getAddress());
			cs.setString(9, patientData.getRelationName());
			cs.setString(10, patientData.getRelationType());
			cs.setString(11, patientData.getRelationContact());
    	} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs);
		}
    }
	
}
