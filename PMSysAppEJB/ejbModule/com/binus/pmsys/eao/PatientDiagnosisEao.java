package com.binus.pmsys.eao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.binus.pmsys.entity.Visitation;
import com.binus.pmsys.utils.ReleaseConnection;
import com.binus.pmsys.utils.Settings;

@Stateless
public class PatientDiagnosisEao {

	public PatientDiagnosisEao() { }
	
	public List<Visitation> getListByDoctor(int doctorID) {
		List<Visitation> visits = new ArrayList<Visitation>();
		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_AppointmentGetListByDoctor(?)}");
			cs.setInt(1, doctorID);
			
			rs = cs.executeQuery();
			
			while(rs.next()) {
				Visitation visit = new Visitation();
				visit.setApptID(rs.getInt(1));
				visit.setPatientID(rs.getInt(2));
				visit.setPatientName(rs.getString(3));
				visit.setPatientGender(rs.getString(4));
				visit.setPatientDOB(rs.getString(5));
				visit.setDoctorID(rs.getInt(6));
				visit.setDocTypeID(rs.getInt(7));
				visit.setDoctorType(rs.getString(8));
				visit.setStaffID(rs.getInt(9));
				visit.setStaffName(rs.getString(10));
				visit.setApptTime(rs.getString(11));
				visit.setApptDate(rs.getString(12));
				visit.setApptFinish(rs.getInt(13));
				visits.add(visit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
		
		return visits;
	}
	
}
