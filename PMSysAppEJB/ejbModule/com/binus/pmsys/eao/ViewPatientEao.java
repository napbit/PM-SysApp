package com.binus.pmsys.eao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.binus.pmsys.entity.Patient;
import com.binus.pmsys.utils.ReleaseConnection;
import com.binus.pmsys.utils.Settings;

/**
 * Session Bean implementation class ViewPatientEao
 */
@Stateless
@LocalBean
public class ViewPatientEao {

    public ViewPatientEao() { }
    
	public List<Patient> getPatients() {
		List<Patient> patientList = new ArrayList<Patient>();
		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call Patient_GetAll()}");
			rs = cs.executeQuery();
			
			Patient patient;
			while(rs.next()) {
				patient = new Patient();
				patient.setId(rs.getInt(1));
				patient.setName(rs.getString(2));
				patient.setGender(rs.getString(3));
				patient.setBirthDate(rs.getString(4));
				patientList.add(patient);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
		
		return patientList;
	}
    
}
