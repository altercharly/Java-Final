package entities;

import java.util.ArrayList;

public class Medicine {
	
	int idMedicine;
	String description;
	String name;
	ArrayList genericDrugs = null;  //TODO: add the get and set for this
	
	//set
	public void setidMedicine (int id) {
		this.idMedicine = id;
	}

	public void setdescription (String desc) {
		this.description = desc;
	}
	
	public void setname (String name) {
		this.name = name;
	}

	public void setgenericDrugs (GenericDrug drug) {
		this.genericDrugs.add(drug); 
	}
	
	//get
	
	public int getidMedicine () {
		return idMedicine;
	}
	
	public String getdescription () {
		return description;
	}
	
	public String getname () {
		return name;
	}

	public ArrayList<genericDrugs> getgenericDrugs () {
		return genericDrugs;
	}
}
