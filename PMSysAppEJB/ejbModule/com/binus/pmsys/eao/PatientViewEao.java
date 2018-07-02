package com.binus.pmsys.eao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.binus.pmsys.entity.Address;
import com.binus.pmsys.entity.NewPatient;
import com.binus.pmsys.entity.Patient;
import com.binus.pmsys.enums.PatientEnum;
import com.binus.pmsys.utils.ReleaseConnection;
import com.binus.pmsys.utils.Settings;

/**
 * Session Bean implementation class ViewPatientEao
 */
@Stateless
@LocalBean
public class PatientViewEao {

    public PatientViewEao() { }
    
	public List<NewPatient> getPatients() {
		List<NewPatient> patients = new ArrayList<NewPatient>();
		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_patientGetAllList()}");
			rs = cs.executeQuery();
			
			while(rs.next()) {
				NewPatient patient = new NewPatient();
				patient.setPatientID(rs.getInt(1));
				patient.setBpjsID(rs.getInt(2));
				patient.setPhoneID(rs.getInt(3));
				patient.setAddressID(rs.getInt(4));
				patient.setEmergencyID(rs.getInt(5));
				patient.setPatientKTP(rs.getString(6));
				patient.setPatientName(rs.getString(7));
				patient.setPatientGender(rs.getString(8));
				patient.setPatientDOB(rs.getString(9));
				patient.setPatientBPJSTypeID(rs.getInt(10));
				patient.setPatientBPJS(rs.getString(11));
				patient.setPatientBPJSType(rs.getString(12));
				patient.setPhoneTypeID(rs.getInt(13));
				patient.setPhoneNumber(rs.getString(14));
				patient.setPhoneType(rs.getString(15));
				patient.setContactName(rs.getString(16));
				patient.setContactRelationship(rs.getString(17));
				patient.setContactNumber(rs.getString(18));
				patient.setAddress(rs.getString(19));
				patient.setProvinceID(rs.getInt(20));
				patient.setKabupatenID(rs.getInt(21));
				patient.setPostCode(rs.getString(22));
				patient.setProvince(rs.getString(23));
				patient.setKabupaten(rs.getString(24));
				patients.add(patient);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
		
		return patients;
	}
	
	public List<NewPatient> getPatientSearch(int filterMode, String term) {
		List<NewPatient> patients = new ArrayList<NewPatient>();
		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_patientSearch(?)}");
			cs.setString(1, term);
			rs = cs.executeQuery();	
			
			while(rs.next()) {
				NewPatient patient = new NewPatient();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs);
		}
		
		return patients;
	}
	
	public Patient getPatient(int id) {
		Patient patient = new Patient();
		Address address = new Address();
		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_patientGetAllData(?)}");
			cs.setInt(1, id);
			rs = cs.executeQuery();
			
			while(rs.next()) {
				patient.setId(rs.getInt(1));
				patient.setPatientKTP(rs.getString(2));
				patient.setName(rs.getString(3));
				patient.setGender(rs.getString(4));
				patient.setBirthDate(rs.getString(5));
				patient.setPatientBPJS(rs.getString(6));
				address.setAddressID(rs.getInt(7));
				address.setNoHP(rs.getString(8));
				address.setNoTel(rs.getString(9));
				address.setAddress(rs.getString(10));
				patient.setAddress(address);
				patient.setRelationID(rs.getInt(11));
				patient.setRelationName(rs.getString(12));
				patient.setRelationType(rs.getString(13));
				patient.setRelationContact(rs.getString(14));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
		
		return patient;
	}
	
	public void editPatient(Patient patientdata) {
		Connection connection = null;
		CallableStatement cs = null;
		
		try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_sp_patientUpdate(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setInt(1, patientdata.getId());
			cs.setString(2, patientdata.getPatientKTP());
			cs.setString(3, patientdata.getPatientBPJS());
			cs.setString(4, patientdata.getName());
			cs.setString(5, patientdata.getGender());
			cs.setString(6, patientdata.getBirthDate());
			cs.setString(7, patientdata.getAddress().getNoHP());
			cs.setString(8, patientdata.getAddress().getNoTel());
			cs.setString(9, patientdata.getAddress().getAddress());
			cs.setString(10, patientdata.getRelationName());
			cs.setString(11, patientdata.getRelationType());
			cs.setString(12, patientdata.getRelationContact());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs);
		}
	}
	
	public void savePatient(Patient patientData) {
		Connection connection = null;
		CallableStatement cs = null;
		
		try {
			connection = Settings.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs);
		}
	}
    
}
