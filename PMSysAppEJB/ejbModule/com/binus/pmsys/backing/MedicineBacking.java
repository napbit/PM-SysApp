package com.binus.pmsys.backing;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.binus.pmsys.eao.MedicineEao;
import com.binus.pmsys.entity.Medicine;
import com.binus.pmsys.utils.DateHelper;

@Named
@SessionScoped
public class MedicineBacking extends BasicBacking {
	private static final long serialVersionUID = 4166569290033816617L;
	
	@EJB
	private transient MedicineEao eao;
	
	private Date expDate;
	
	private Medicine newMedicine;
	private Medicine editMedicine;
	private Medicine medicine;
	private List<Medicine> medicines;
	
	public MedicineBacking() { }
	
	@PostConstruct
	public void init() {
		medicines = eao.getMedicineList();
		newMedicine = new Medicine();
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
	
	public Medicine getEditMedicine() {
		return editMedicine;
	}

	public void setEditMedicine(Medicine editMedicine) {
		this.editMedicine = editMedicine;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	
	public Medicine getNewMedicine() {
		return newMedicine;
	}

	public void setNewMedicine(Medicine newMedicine) {
		this.newMedicine = newMedicine;
	}

	public String viewMedicine(Medicine m) {
		this.medicine = new Medicine(m);
		return "view.xhtml?faces-redirect=true";
	}
	
	public String editMedicine() {
		editMedicine = new Medicine(this.medicine);
		return "edit.xhtml?faces-redirect=true";
	}
	
	public String finalizeNewMedicine() {
		newMedicine.setExpDate(DateHelper.formatDateToString(expDate, "yyyy-MM-dd"));
		newMedicine.setMedicineFinalPrice(newMedicine.calculateFinalPrice());
		return "review.xhtml?faces-redirect=true";
	}
}
