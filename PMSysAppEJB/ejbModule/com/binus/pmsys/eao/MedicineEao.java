package com.binus.pmsys.eao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.binus.pmsys.entity.Medicine;
import com.binus.pmsys.utils.ReleaseConnection;
import com.binus.pmsys.utils.Settings;

/**
 * Session Bean implementation class MedicineEao
 */
@Stateless
public class MedicineEao {
	
    public MedicineEao() { }
    
    public List<Medicine> getMedicineList() {
    	List<Medicine> meds = new ArrayList<Medicine>();
    	Connection connection = null;
    	CallableStatement cs = null;
    	ResultSet rs = null;
    	
    	try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_medicineGetAllList}");
			rs = cs.executeQuery();
			
			while(rs.next()) {
				Medicine med = new Medicine();
				med.setMedID(rs.getInt(1));
				med.setMedName(rs.getString(2));
				med.setMedCategory(rs.getString(3));
				med.setMedType(rs.getString(4));
				med.setActiveIngredients(rs.getString(5));
				med.setStockQty(rs.getInt(6));
				med.setMedicinePrice(rs.getFloat(7));
				med.setMedicineHNA(rs.getFloat(8));
				med.setMedicinePPN(rs.getFloat(9));
				med.setExpDate(rs.getString(10));
				meds.add(med);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
    	
    	return meds;
    }
}
