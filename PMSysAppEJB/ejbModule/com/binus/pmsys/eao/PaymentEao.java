package com.binus.pmsys.eao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.binus.pmsys.entity.Perscription;
import com.binus.pmsys.utils.ReleaseConnection;
import com.binus.pmsys.utils.Settings;

/**
 * Session Bean implementation class PaymentEao
 */
@Stateless
public class PaymentEao {

    /**
     * Default constructor. 
     */
    public PaymentEao() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Perscription> getPerscriptionByPatient(int patientID) {
    	List<Perscription> perscriptions = new ArrayList<Perscription>();
    	Connection connection = null;
    	CallableStatement cs = null;
    	ResultSet rs = null;
    	
    	try {
			connection = Settings.getConnection();
			cs = connection.prepareCall("{call sp_prescriptiongetAllListByPatient(?)}");
			cs.setInt(1, patientID);
			
			rs = cs.executeQuery();
			
			while(rs.next()) {
				Perscription per = new Perscription();
				per.setPerID(rs.getInt(1));
				per.setMedID(rs.getInt(2));
				per.setMedName(rs.getString(3));
				per.setMedCategory(rs.getString(4));
				per.setMedType(rs.getString(5));
				per.setActiveIngredients(rs.getString(6));
				per.setMedPrice(rs.getFloat(7));
				per.setMedHNA(rs.getFloat(8));
				per.setMedPPN(rs.getFloat(9));
				per.setPatID(rs.getInt(10));
				per.setPatName(rs.getString(11));
				per.setInstructions(rs.getString(12));
				per.setMedFinalPrice(per.calculateFinalPrice());
				perscriptions.add(per);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReleaseConnection.close(connection, cs, rs);
		}
    	
    	return perscriptions;
    }
    
}
