package com.binus.pmsys.eao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.binus.pmsys.entity.Doctor;
import com.binus.pmsys.utils.ReleaseConnection;
import com.binus.pmsys.utils.Settings;

/**
 * Session Bean implementation class PatientVisitationEao
 */
@Stateless
public class PatientVisitationEao {

    /**
     * Default constructor. 
     */
    public PatientVisitationEao() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Doctor> getAvailableDoctor(String day, String fromTime, String toTime){
    	List<Doctor> doctors = new ArrayList<Doctor>();
    	Connection connection = null;
    	CallableStatement cs = null;
    	ResultSet rs = null;
    	
    	try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_doctorGetShiftBetween(?,?,?)}");
			cs.setString(1, day);
			cs.setString(2, fromTime);
			cs.setString(3, toTime);
			
			rs = cs.executeQuery();
			
			while(rs.next()) {
				Doctor doc = new Doctor();
				doc.setDoctorID(rs.getInt(1));
				doc.setStaffID(rs.getInt(2));
				doc.setStaffName(rs.getString(3));
				doc.setStaffGender(rs.getString(4));
				doc.setPositionID(rs.getInt(5));
				doc.setStaffPosition(rs.getString(6));
				doc.setDoctorTypeID(rs.getInt(7));
				doc.setDoctorType(rs.getString(8));
				doc.setClinicName(rs.getString(9));
				doctors.add(doc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
    	
    	return doctors;
    }
    
    public void assignDoctorPatient(int patientID, int doctorID, String currentTime, String currentDate) {
    	Connection connection = null;
    	CallableStatement cs = null;
    	ResultSet rs = null;
    	
    	try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_appointmentInsert(?,?,?,?)}");
			cs.setInt(1, patientID);
			cs.setInt(2, doctorID);
			cs.setString(3, currentTime);
			cs.setString(4, currentDate);
			
			cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
    }

}
