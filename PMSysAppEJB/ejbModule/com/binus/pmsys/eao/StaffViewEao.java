package com.binus.pmsys.eao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.binus.pmsys.entity.Position;
import com.binus.pmsys.entity.Staff;
import com.binus.pmsys.enums.BasicEnum;
import com.binus.pmsys.enums.PatientEnum;
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
	
	public List<Position> getPositions() {
		List<Position> positions = new ArrayList<Position>();
		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_staffPositionGetAllList}");
			
			rs = cs.executeQuery();
			
			while(rs.next()) {
				Position pos = new Position();
				pos.setId(rs.getInt(1));
				pos.setName(rs.getString(2));
				positions.add(pos);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
		
		return positions;
	}
	
	public int updateStaff(Staff staff) {
		Connection connection = null;
		CallableStatement cs = null;
		int i = 0;
		
		try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_StaffUpdate(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setInt(1, staff.getStaffID());
			cs.setString(2, staff.getStaffKTP());
			cs.setString(3, staff.getStaffName());
			cs.setString(4, staff.getStaffDOB());
			cs.setString(5, staff.getStaffGender());
			cs.setString(6, staff.getJoinDate());
			cs.setString(7, staff.getLeaveDate());
			cs.setInt(8, staff.getPositionID());
			cs.setString(9, staff.getPhoneNumber());
			cs.setInt(10, PatientEnum.getPhoneTypeByString(staff.getPhoneType()));
			cs.setInt(11, staff.getClinicID());
			cs.setInt(12, staff.getProvinceID());
			cs.setInt(13, staff.getKabupatenID());
			cs.setString(14, staff.getAddress());
			cs.setString(15, staff.getPostCode());
			cs.setString(16, staff.getUsername());
			
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
	
	public List<Staff> searchStaff(int mode, String search){
		List<Staff> staffs = new ArrayList<Staff>();
		Connection connection = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try {
			connection = Settings.getConnection();
			
			switch (mode) {
			case BasicEnum.FILTER_NO_RM:
				cs = connection.prepareCall("{call sp_staffSearchNIK(?)}");
				break;
			case BasicEnum.FILTER_NAME:
				cs = connection.prepareCall("{call sp_staffSearchName(?)}");
				break;
			case BasicEnum.FILTER_GENDER:
				cs = connection.prepareCall("{call sp_staffSearchGender(?)}");
				break;
			case BasicEnum.FILTER_DOB:
				cs = connection.prepareCall("{call sp_staffSearchPosition(?)}");
				break;
			case 5:
				cs = connection.prepareCall("{call sp_staffSearchJoinDate(?)}");
			default:
				break;
			}
			
			cs.setString(1, search);
			
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
				staffs.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
		
		return staffs;
	}
}
