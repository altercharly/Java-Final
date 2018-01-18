package business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import data.*;
import entities.*;

public class Controller {
	
	


void countPrescription(int affiliate, int idHealthPlan){
	
	if (this.validatePatient(affiliate)==true && this.validateHealthPlan(idHealthPlan)==true){
		
		PatientCatalog patientcatalog = new PatientCatalog();
	int idPatient =	patientcatalog.getPatient(affiliate).getidPatient();
		
		this.validatecantmaxPrescription(idHealthPlan, idPatient);
	}else {}
	
}
	
	
public HealthPlan getHealthPlan (int idHealthPlan){
	HealthPlan hp = null;
	HealthPlanCatalog hplancatalog = new HealthPlanCatalog();
	
	hp=hplancatalog.getHPbyId(idHealthPlan);
	return hp;
	
}	

public Professional getProfessional (int regNumber){
	Professional professional= null;
	ProfessionalCatalog profcatalog = new ProfessionalCatalog();
	professional= profcatalog.getProByRegistNumber(regNumber);
	return professional;
}

public boolean validateUser (int dni){
	//asks UserCatalog if the dni number belongs to a registered user
	
	UsersCatalog user= new UsersCatalog();
	if (user.getUser(dni)!=null){
		System.out.println("Se encontró el usuario!");
		return true;
	}else {
		System.out.println("No se encontró el usuario!");
		return false;
	}	
}
boolean validatePatient(int affiliate){
	PatientCatalog patientcatalog= new PatientCatalog();
	if (patientcatalog.getPatient(affiliate)!=null){
		return true;
	}else {
		return false;
	}	}

public Patient getPatient(int affiliate){
	Patient p = new Patient();
	PatientCatalog pcatalog= new PatientCatalog();
	p=pcatalog.getPatient(affiliate);
	return p;
}

boolean validateHealthPlan (int idHP){
	//asks HealthPlanCatalog if the idHP belongs to a registered HP
	
	HealthPlanCatalog hplan= new HealthPlanCatalog();
	if (hplan.getHPbyId(idHP)!=null){
		return true;
	}else {
		return false;
	}	
}
public Medicine getMedicineByName(String medicineName){
	Medicine medicine = new Medicine();
	MedicineCatalog mcatalog = new MedicineCatalog();
	medicine=mcatalog.getMedicine(medicineName);
	return medicine;
}
public boolean validatecantmaxPrescription(int idHealthPlan, int idPatient){
	//asks PrescriptionCatalog if the pacient has reached the maximum number of prescriptions per month
	//according to the maximum number of prescriptions allowed (by the HealthPlan)
	//validation required before using this method
	
	HealthPlanCatalog hplancatalog = new HealthPlanCatalog();
	HealthPlan hplan = hplancatalog.getHPbyId(idHealthPlan);
	int cantmaxprescription=hplan.getcantMaxPrescription();
	
	PrescriptionCatalog prescriptioncatalog = new PrescriptionCatalog();
	Date today=new Date();
	
	if (prescriptioncatalog.countPrescriptionsPatient2(idPatient,today)<=cantmaxprescription){
	return true;}
	else {return false;}
		
}


public static String getDate(Date date) {
   //useful method
	
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    return format.format(date);
}

public GenericDrug getGenericDrug (String gdrug){
//gets a generic drug giving the name
	
	GenericDrug genericdrug = new GenericDrug();
	GenericDrugCatalog gdrugcatalog = new GenericDrugCatalog();
	genericdrug= gdrugcatalog.getGenericDrug(gdrug);
	
	
	return genericdrug;
}

public ArrayList<GenericDrug> getAllGenericDrug (){
	//gets all generic drugs 
	ArrayList<GenericDrug> gdrugs = new ArrayList<GenericDrug>();
	GenericDrugCatalog gdrugcatalog = new GenericDrugCatalog();
	gdrugs=gdrugcatalog.getgenericDrugs();
	return gdrugs;
}


public ArrayList<Medicine> getMedicineByDrug (int idgdrug){
	// returns all the medicine with the same generic drug
	
	ArrayList<Medicine> medicines = new ArrayList<Medicine>();
	MedicineCatalog mcatalog = new MedicineCatalog();
	medicines=mcatalog.getMedicineWithSameGeneric(idgdrug);
	
	return medicines;
}

public ArrayList<Presentation> getPresentationByMedicine (int idmedicine){

	ArrayList<Presentation> presentations = new ArrayList<Presentation>();
	PresentationCatalog pcatalog = new PresentationCatalog();
	presentations=pcatalog.getPresentationByMedicine(idmedicine);
	
	return presentations;
}

public Item getItem (int idmedicine, int idpresentation){
	Item item = new Item();
	ItemCatalog icatalog = new ItemCatalog();
	item = icatalog.getItem(idmedicine, idpresentation);
	return item;
}

public void updateCantItem (Item item, int cant){
	//sets the new cant of the item and updates in the DB
	ItemCatalog icatalog = new ItemCatalog();
	int newCant = item.getcantStock()-cant;
	item.setcantStock(newCant);
	icatalog.updateItem(item);
}

public double calcPriceItem (Item item, int cant){
	double priceItem;
	priceItem=item.getprice()*cant;
	return priceItem;
}


public void setPrescription(Prescription p){
	PrescriptionCatalog pcatalog = new PrescriptionCatalog();
	pcatalog.addPrescription(p);
}

public void setPrescription_Item(Prescription_Item pi){
	Prescription_ItemCatalog picatalog = new Prescription_ItemCatalog();
	picatalog.addPrescriptionItem(pi);
}

public void addPatient (Patient patient){
	
	PatientCatalog cpatient = new PatientCatalog();
cpatient.addPatient(patient);
}


public void addMedicine(Medicine medicine) {
	MedicineCatalog cmedicine = new MedicineCatalog();
	cmedicine.addMedicine(medicine);
	
}

}
