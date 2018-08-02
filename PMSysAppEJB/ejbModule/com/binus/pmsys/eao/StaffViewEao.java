package com.binus.pmsys.eao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.binus.pmsys.entity.Staff;
import com.binus.pmsys.utils.ReleaseConnection;
import com.binus.pmsys.utils.Settings;

@Stateless
public class StaffViewEao {

	public StaffViewEao() {	}
	
	public List<Staff> getAllStaff(){
		List<Staff> staff = new ArrayList<Staff>();
		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_staffGetAllList()}");
			
			rs = cs.executeQuery();
			
			while(rs.next()) {
				Staff emp = new Staff();
				emp.setStaffID(rs.getInt(1));
				emp.setStaffKTP(rs.getString(2));
				emp.setStaffName(rs.getString(3));
				emp.setStaffDOB(rs.getString(4));
				emp.setStaffGender(rs.getString(5));
				emp.setJoinDate(rs.getString(6));
				emp.setLeaveDate(rs.getString(7));
				emp.setPositionID(rs.getInt(8));
				emp.setPosition(rs.getString(9));
				emp.setContactID(rs.getInt(10));
				emp.setPhoneNumber(rs.getString(11));
				emp.setPhoneType(rs.getString(12));
				emp.setClinicID(rs.getInt(13));
				emp.setClinicName(rs.getString(14));
				emp.setAddressID(rs.getInt(15));
				emp.setAddress(rs.getString(16));
				emp.setPostCode(rs.getString(17));
				emp.setProvinceID(rs.getInt(18));
				emp.setProvince(rs.getString(19));
				emp.setKabupatenID(rs.getInt(20));
				emp.setKabupaten(rs.getString(21));
				emp.setLoginID(rs.getInt(22));
				emp.setUsername(rs.getString(23));
				staff.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
		
		return staff;
	}
}
