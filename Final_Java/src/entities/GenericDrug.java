package entities;

public class GenericDrug {

	int drugId;
	String drugName;
	
	//set
	public void setdrugId (int Id) {
		this.drugId = Id;
	}
	
	public void setdrugName (String name) {
		this.drugName = name;
	}
	
	//get
	int getdrugId () {
		return drugId;
	}
	
	String getdrugName () {
		return drugName;
	}
	
}
