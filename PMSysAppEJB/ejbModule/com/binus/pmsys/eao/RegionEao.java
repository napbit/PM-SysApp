package com.binus.pmsys.eao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.binus.pmsys.entity.Kabupaten;
import com.binus.pmsys.entity.Province;
import com.binus.pmsys.utils.ReleaseConnection;
import com.binus.pmsys.utils.Settings;

/**
 * Session Bean implementation class RegionEao
 */
@Stateless
public class RegionEao {

    /**
     * Default constructor. 
     */
    public RegionEao() {
        // TODO Auto-generated constructor stub
    }

    public List<Province> getProvinces() {
    	List<Province> provinces = new ArrayList<>();
    	Connection connection = null;
    	CallableStatement cs = null;
    	ResultSet rs = null;
    	
    	try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_provinceGetAllList}");
			rs = cs.executeQuery();
			
			while(rs.next()) {
				Province province = new Province();
				province.setId(rs.getInt(1));
				province.setProvinceName(rs.getString(2));
				provinces.add(province);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
    	
    	return provinces;
    }
    
    public List<Kabupaten> getKabupatens() {
    	List<Kabupaten> kabupatens = new ArrayList<>();
    	Connection connection = null;
    	CallableStatement cs = null;
    	ResultSet rs = null;
    	
    	try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_kabupatenGetAllList}");
			rs = cs.executeQuery();
			
			while(rs.next()) {
				Kabupaten kabupaten = new Kabupaten();
				kabupaten.setId(rs.getInt(1));
				kabupaten.setKabupatenName(rs.getString(2));
				kabupatens.add(kabupaten);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
    	
    	return kabupatens;
    }
}
