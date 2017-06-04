package entities;

public class Prescription_Item {
	
	// I dont know is this class is useless
	int idPrescription;
	int idItem;
	
	//set
	public void setidPrescription (int idpresc) {
		this.idPrescription = idpresc;
	}
	
	public void setidItem (int idItem) {
		this.idItem = idItem;
	}
	
	//get
	public int getidPrescription () {
		return idPrescription;
	}
	
	public int getidItem () {
		return idItem;
	}
}
