package entities;

public class Prescription_Item {
	
	// I dont know is this class is useless
	//Its not useless! keeps the number of each medicine in a prescription
	int idPrescription;
	int idItem;
	int cantItem;
	
	
	public void setidPrescription (int idpresc) {
		this.idPrescription = idpresc;
	}
	

	public int getidPrescription () {
		return idPrescription;
	}
	
	public int getidItem () {
		return idItem;
	}


	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}


	public int getCantItem() {
		return cantItem;
	}


	public void setCantItem(int cantItem) {
		this.cantItem = cantItem;
	}
}
