package com.binus.pmsys.backing;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.binus.pmsys.eao.DoctorEao;
import com.binus.pmsys.eao.PatientViewEao;
import com.binus.pmsys.eao.PaymentEao;
import com.binus.pmsys.entity.Doctor;
import com.binus.pmsys.entity.NewPatient;
import com.binus.pmsys.entity.Payment;
import com.binus.pmsys.entity.Perscription;

@Named
@SessionScoped
public class PaymentBacking extends BasicBacking{
	private static final long serialVersionUID = 1515243480424898631L;
	
	@EJB
	private transient PatientViewEao patientEao;
	
	@EJB
	private transient DoctorEao doctorEao;
	
	@EJB
	private transient PaymentEao eao;
	
	private int filterMode;
	private String search;
	
	private NewPatient patient;
	private Doctor doctor;
	
	private Payment payment;
	private List<Payment> payments;
	
	private List<Perscription> perscriptions;
	
	private boolean finalCalcPanel;
	
	public PaymentBacking() { }
	
	@PostConstruct
	public void init() {
		setPayments(dataPreFill());
	}
	
	public List<Payment> dataPreFill(){
		List<Payment> pays = new ArrayList<Payment>();
		Payment pay = new Payment(1, 1438, "Sandy", 1, "Branningham", 0, 0, "BPJS", "2018-07-10");
		Payment pay2 = new Payment(2, 1440, "Rio Santoso", 1, "Branningham", 0, 0, "Non-BPJS", "2018-07-10");
		pays.add(pay);
		pays.add(pay2);
		return pays;
	}
	
	public int getFilterMode() {
		return filterMode;
	}

	public void setFilterMode(int filterMode) {
		this.filterMode = filterMode;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public NewPatient getPatient() {
		return patient;
	}

	public void setPatient(NewPatient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public List<Perscription> getPerscriptions() {
		return perscriptions;
	}

	public void setPerscriptions(List<Perscription> perscriptions) {
		this.perscriptions = perscriptions;
	}

	public boolean isFinalCalcPanel() {
		return finalCalcPanel;
	}

	public void setFinalCalcPanel(boolean finalCalcPanel) {
		this.finalCalcPanel = finalCalcPanel;
	}

	public String viewBillingDetail(Payment pay) {
		this.payment = new Payment(pay);
		this.patient = patientEao.getPatientAllData(payment.getPatientID());
		this.doctor = doctorEao.getDoctorAllData(payment.getDoctorID());
		this.perscriptions = eao.getPerscriptionByPatient(payment.getPatientID());
		
		return "view.xhtml?faces-redirect=true";
	}
	
	public void calculateFinalTotals() {
		for (Perscription pers : perscriptions) {
			payment.setSum(runningSum(payment.getSum(), pers.getMedFinalPrice()));
		}
		
		payment.setFinalPrice(payment.getSum());
		
		setFinalCalcPanel(true);
		
		System.out.println(payment.getFinalPrice());
	}
	
	public void calculateChange() {
		payment.setChange(payment.getPaid() - payment.getFinalPrice());
	}
	
	private float runningSum(float currSum, float finalPrice) {
		return currSum + finalPrice;
	}
}
