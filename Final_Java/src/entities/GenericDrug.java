package entities;

public class GenericDrug {

	int idDrug;
	String drugName;
	
	//set
	public void setidDrug (int Id) {
		this.idDrug = Id;
	}
	
	public void setdrugName (String name) {
		this.drugName = name;
	}
	
	//get
	int getidDrug () {
		return idDrug;
	}
	
	String getdrugName () {
		return drugName;
	}
	
}
