package com.binus.pmsys.eao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.ejb.Stateless;

import com.binus.pmsys.entity.Staff;
import com.binus.pmsys.enums.PatientEnum;
import com.binus.pmsys.utils.ReleaseConnection;
import com.binus.pmsys.utils.Settings;

/**
 * Session Bean implementation class staffRegistrationEao
 */
@Stateless
public class StaffRegistrationEao {

    /**
     * Default constructor. 
     */
    public StaffRegistrationEao() { }
    
    public int insertNewStaff(Staff staff, String password) {
    	int i = 0;
    	Connection connection = null;
		CallableStatement cs = null;
		
		try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_staffInsert(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, staff.getStaffKTP());
			cs.setString(2, staff.getStaffName());
			cs.setString(3, staff.getStaffDOB());
			cs.setString(4, staff.getStaffGender());
			cs.setString(5, staff.getJoinDate());
			cs.setInt(6, staff.getPositionID());
			cs.setString(7, staff.getPhoneNumber());
			cs.setInt(8, PatientEnum.getPhoneTypeByString(staff.getPhoneType()));
			cs.setInt(9, 1);
			cs.setInt(10, staff.getProvinceID());
			cs.setInt(11, staff.getKabupatenID());
			cs.setString(12, staff.getAddress());
			cs.setString(13, staff.getPostCode());
			cs.setString(14, staff.getUsername());
			cs.setString(15, password);
			
			if(!cs.execute()) {
				i = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs);
		}
		
		return i;
    }
}
