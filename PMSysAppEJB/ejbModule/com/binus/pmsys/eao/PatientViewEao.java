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
				patient.setPatientSEP(rs.getString(25));
				patients.add(patient);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
		
		return patients;
	}
	
	public void updatePatient(NewPatient patient) {
		Connection connection = null;
		CallableStatement cs = null;
		
		try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_patientUpdate(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setInt(1, patient.getPatientID());
			cs.setString(2, patient.getPatientKTP());
			cs.setString(3, patient.getPatientName());
			cs.setString(4, patient.getPatientGender());
			cs.setString(5, patient.getPatientDOB());
			cs.setString(6, patient.getPatientBPJS());
			cs.setInt(7, patient.getPatientBPJSTypeID());
			cs.setString(8, patient.getPhoneNumber());
			cs.setInt(9, patient.getPhoneTypeID());
			cs.setString(10, patient.getContactName());
			cs.setString(11, patient.getContactRelationship());
			cs.setString(12, patient.getContactNumber());
			cs.setString(13, patient.getAddress());
			cs.setInt(14, patient.getProvinceID());
			cs.setInt(15, patient.getKabupatenID());
			cs.setString(16, patient.getPostCode());
			
			cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs);
		}
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
	
	public List<NewPatient> getPatientSearchName(String term) {
		List<NewPatient> patients = new ArrayList<NewPatient>();
		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_patientSearchName(?)}");
			cs.setString(1, term);
			
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
				patient.setPatientSEP(rs.getString(25));
				patients.add(patient);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs);
		}
		
		return patients;
	}
	
	public List<NewPatient> getPatientSearchGender(String term){
		List<NewPatient> patients = new ArrayList<NewPatient>();
		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_patientSearchGender(?)}");
			cs.setString(1, term);
			
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
				patient.setPatientSEP(rs.getString(25));
				patients.add(patient);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs);
		}
		
		return patients;
	}
    
	public List<NewPatient> getPatientSearchDOB(String term) {
		List<NewPatient> patients = new ArrayList<NewPatient>();
		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_patientSearchDate(?)}");
			cs.setString(1, term);
			
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
				patient.setPatientSEP(rs.getString(25));
				patients.add(patient);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs);
		}
		
		return patients;
	}
}
