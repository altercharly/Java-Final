package entities;

public class Medicine {
	
	int idMedicine;
	String description;
	String name;
	
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
}
