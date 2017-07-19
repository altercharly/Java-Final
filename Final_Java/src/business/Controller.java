package business;

import java.text.SimpleDateFormat;
import java.util.Date;

import data.*;
import entities.*;

public class Controller {
	
	UsersCatalog UsersCat = new UsersCatalog();


void countPrescription(int affiliate, int idHealthPlan){
	
	if (this.validatePatient(affiliate)==true && this.validateHealthPlan(idHealthPlan)==true){
		
		PatientCatalog patientcatalog = new PatientCatalog();
	int idPatient =	patientcatalog.getPatient(affiliate).getidPatient();
		
		this.validatecantmaxPrescription(idHealthPlan, idPatient);
	}else {}
	
}
	
	
HealthPlan getHealthPlan (int idHealthPlan){
	HealthPlan hp = null;
	HealthPlanCatalog hplancatalog = new HealthPlanCatalog();
	hp=hplancatalog.getHPbyId(idHealthPlan);
	return hp;
	
}	

Professional getProfessional (int regNumber){
	Professional professional= null;
	ProfessionalCatalog profcatalog = new ProfessionalCatalog();
	professional= profcatalog.getProByRegistNumber(regNumber);
	return professional;
}

boolean validateUser (int dni){
	//asks UserCatalog if the dni number belongs to a registered user
	
	UsersCatalog user= new UsersCatalog();
	if (user.getUser(dni)!=null){
		return true;
	}else {
		return false;
	}	
}
boolean validatePatient(int affiliate){
	//PacientCatalog patientcatalog= new PatientCatalog();
	//if (patientcatalog.getpatient(affiliate)!=null){
		//return true;
	//}else {
		//return false;
	//}	
	
	
	return false;}

boolean validateHealthPlan (int idHP){
	//asks HealthPlanCatalog if the idHP belongs to a registered HP
	
	HealthPlanCatalog hplan= new HealthPlanCatalog();
	if (hplan.getHPbyId(idHP)!=null){
		return true;
	}else {
		return false;
	}	
}
boolean validatecantmaxPrescription(int idHealthPlan, int idPatient){
	//asks PrescriptionCatalog if the pacient has reached the maximum number of prescriptions per month
	//according to the maximum number of prescriptions allowed (by the HealthPlan)
	//validation required before using this method
	
	HealthPlanCatalog hplancatalog = new HealthPlanCatalog();
	HealthPlan hplan = hplancatalog.getHPbyId(idHealthPlan);
	int cantmaxprescription=hplan.getcantMaxPrescription();
	
	PrescriptionCatalog prescriptioncatalog = new PrescriptionCatalog();
	Date today=new Date();
	
	if (prescriptioncatalog.countPrescriptionsPatient(idPatient,today)<=cantmaxprescription){
	return true;}
	else {return false;}
		
}


public static String getDate(Date date) {
   //useful method
	
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    return format.format(date);
}


}
