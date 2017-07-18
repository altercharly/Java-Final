package business;

import java.text.SimpleDateFormat;
import java.util.Date;

import data.*;
import entities.*;

public class Controller {
	
	UsersCatalog UsersCat = new UsersCatalog();



boolean validateUser (int dni){
	//asks UserCatalog if the dni number belongs to a registered user
	
	UsersCatalog user= new UsersCatalog();
	if (user.getUser(dni)!=null){
		return true;
	}else {
		return false;
	}	
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
boolean validatecantmaxPrescription(int idHealthPlan, int affiliateNumber){
	//asks PacientCatalog if the pacient has reached the maximum number of prescriptions per month
	//according to the maximum number of prescriptions allowed (by the HealthPlan)
	//validation of the healthplan and patient required before using this method
	
	HealthPlanCatalog hplancatalog = new HealthPlanCatalog();
	HealthPlan hplan = hplancatalog.getHPbyId(idHealthPlan);
	int cantmaxprescription=hplan.getcantMaxPrescription();
	
	//PatientCatalog patientcatalog = new PatientCatalog();
	//Patient patient =	patientcatalog.getPatientbyaffiliateNumber(affiliateNumber);
	Date today=new Date();
	String date = getDate(today);
	//if (patientcatalog.getcantPrescription(affiliateNumber,date)<=cantmaxprescription){
	//return true;}
	//else {return false;}
		
	return false;}

public static String getDate(Date date) {
   //useful method
	
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    return format.format(date);
}

}
