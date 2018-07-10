package com.binus.pmsys.backing;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.binus.pmsys.eao.MedicineEao;
import com.binus.pmsys.entity.Medicine;

@Named
@SessionScoped
public class MedicineBacking extends BasicBacking {
	private static final long serialVersionUID = 4166569290033816617L;
	
	@EJB
	private transient MedicineEao eao;
	
	private Medicine medicine;
	private List<Medicine> medicines;
	
	public MedicineBacking() { }
	
	@PostConstruct
	public void init() {
		medicines = eao.getMedicineList();
	}
	
	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}
	
	
	
}
