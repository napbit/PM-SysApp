package com.binus.pmsys.eao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.binus.pmsys.entity.MedicalRecord;
import com.binus.pmsys.entity.Perscription;
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
	
	public void finishMedicalVisit(int apptID, int finishStatus) {
		Connection connection = null;
		CallableStatement cs = null;
		
		try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_appointmentUpdate(?,?)}");
			cs.setInt(1, apptID);
			cs.setInt(2, finishStatus);
			
			cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs);
		}
	}
	
	public void insertMedicalRecord(MedicalRecord record) {
		Connection connection = null;
		CallableStatement cs = null;
		
		try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_medicalRecordInsert(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setInt(1, record.getPatientID());
			cs.setInt(2, record.getDoctorID());
			cs.setString(3, record.getRecordSEP());
			cs.setString(4, record.getMedicalSubject());
			cs.setString(5, record.getMedicalObject());
			cs.setString(6, record.getMedicalAssessment());
			cs.setString(7, record.getMedicalPlanning());
			cs.setInt(8, record.getPatientSystolic());
			cs.setInt(9, record.getPatientDiastolic());
			cs.setInt(10, record.getPatientWeight());
			cs.setInt(11, record.getPatientHeight());
			cs.setString(12, record.getRecordDate());
			cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs);
		}
	
	}
	
	public void insertPerscription(Perscription pers, int patientID) {
		Connection connection = null;
		CallableStatement cs = null;
		
		try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_prescriptionInsert(?,?,?)}");
			cs.setInt(1, pers.getMedID());
			cs.setInt(2, patientID);
			cs.setString(3, pers.getInstructions());
			
			cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs);
		}
	}
	
}
