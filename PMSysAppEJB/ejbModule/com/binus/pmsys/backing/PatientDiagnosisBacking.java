package com.binus.pmsys.backing;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.binus.pmsys.eao.MedicineEao;
import com.binus.pmsys.eao.PatientDiagnosisEao;
import com.binus.pmsys.eao.PatientViewEao;
import com.binus.pmsys.entity.MedicalRecord;
import com.binus.pmsys.entity.Medicine;
import com.binus.pmsys.entity.NewPatient;
import com.binus.pmsys.entity.Perscription;
import com.binus.pmsys.entity.Visitation;
import com.binus.pmsys.enums.DiagnosisEnum;

@Named
@SessionScoped
public class PatientDiagnosisBacking implements Serializable {
	private static final long serialVersionUID = 700326609867752540L;
	
	@EJB
	private transient PatientDiagnosisEao eao;
	
	@EJB
	private transient PatientViewEao patientEao;
	
	@EJB
	private transient MedicineEao medicineEao;
	
	private String search;
	private int filterMode, medicineFilter;
	
	private NewPatient patient;
	private MedicalRecord medicalRecord;
	
	private Visitation visit;
	private List<Visitation> visits;
	
	private Medicine medicine;
	private List<Medicine> medicines;
	
	private Perscription perscription;
	private List<Perscription> perscriptions;
	
	private boolean medicineDialog, patientDialog;
	private boolean medPanel, insPanel;
	
	public PatientDiagnosisBacking() {	}
	
	@PostConstruct
	public void init() {
		visits = new ArrayList<Visitation>();
		visits = eao.getListByDoctor(1); // TODO: get by login
	}
	
	public boolean isMedicineDialog() {
		return medicineDialog;
	}

	public void setMedicineDialog(boolean medicineDialog) {
		this.medicineDialog = medicineDialog;
	}
	
	public boolean isPatientDialog() {
		return patientDialog;
	}

	public void setPatientDialog(boolean patientDialog) {
		this.patientDialog = patientDialog;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getFilterMode() {
		return filterMode;
	}

	public void setFilterMode(int filterMode) {
		this.filterMode = filterMode;
	}

	public int getMedicineFilter() {
		return medicineFilter;
	}

	public void setMedicineFilter(int medicineFilter) {
		this.medicineFilter = medicineFilter;
	}

	public List<Visitation> getVisits() {
		return visits;
	}

	public void setVisits(List<Visitation> visits) {
		this.visits = visits;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public Visitation getVisit() {
		return visit;
	}

	public void setVisit(Visitation visit) {
		this.visit = visit;
	}

	public NewPatient getPatient() {
		return patient;
	}

	public void setPatient(NewPatient patient) {
		this.patient = patient;
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

	public Perscription getPerscription() {
		return perscription;
	}

	public void setPerscription(Perscription perscription) {
		this.perscription = perscription;
	}

	public List<Perscription> getPerscriptions() {
		return perscriptions;
	}

	public void setPerscriptions(List<Perscription> perscriptions) {
		this.perscriptions = perscriptions;
	}

	public boolean isMedPanel() {
		return medPanel;
	}

	public void setMedPanel(boolean medPanel) {
		this.medPanel = medPanel;
	}

	public boolean isInsPanel() {
		return insPanel;
	}

	public void setInsPanel(boolean insPanel) {
		this.insPanel = insPanel;
	}

	public void dialogCloseListener() {
		setMedicineDialog(false);
		setMedPanel(false);
		setInsPanel(false);
	}
	
	public void closePatientDialog() {
		setPatientDialog(false);
	}
	
	public void openPatientDialog() {
		setPatientDialog(true);
		patient = patientEao.getPatientAllData(visit.getPatientID());
	}
	
	public void openMedicineDialog() {
		setMedicineDialog(true);
		setMedPanel(true);
		setInsPanel(false);
		perscription = new Perscription();
		medicines = medicineEao.getMedicineList();
	}
	
	public void instructionPanelOpen() {
		setMedPanel(false);
		setInsPanel(true);
	}
	
	public String redirectPerscription() {
		if(perscriptions != null) {
			perscriptions = new ArrayList<Perscription>();
		}
		
		return "resep.xhtml?faces-redirect=true";
	}
	
	public String diagnosePatient(Visitation visit) {
		this.visit = new Visitation(visit);
		medicalRecord = new MedicalRecord();
		return "diagnosa.xhtml?faces-redirect=true";
	}
	
	public void addNewPerscription() {
		perscription.setMedID(medicine.getMedID());
		perscription.setMedName(medicine.getMedName());
		perscription.setMedCategory(medicine.getMedCategory());
		perscription.setMedType(medicine.getMedType());
		perscription.setActiveIngredients(medicine.getActiveIngredients());
		perscriptions.add(perscription);
		dialogCloseListener();
	}
	
	public String finalizeDiagnoseVisitation() {
		medicalRecord.setPatientID(visit.getPatientID());
		medicalRecord.setDoctorID(visit.getDoctorID());
		medicalRecord.setRecordDate(LocalDate.now().toString());
		eao.insertMedicalRecord(medicalRecord);	
		eao.finishMedicalVisit(visit.getApptID(), DiagnosisEnum.FINISHED);
		for (Perscription pre : perscriptions) {
			eao.insertPerscription(pre, visit.getPatientID());
		}
		visits = eao.getListByDoctor(1); // TODO: by login information
		return "list.xhtml?faces-redirect=true";
	}
}
