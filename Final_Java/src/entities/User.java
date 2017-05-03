package entities;

public class User {

	int dni;
	String email;
	String surname;
	String name;
	String type;
	int id;		
	String password;
	
	public User(){	
		
	}
    
    
	public User(int dni, String name, String surname){
		setDni(dni);
		setName(name);
		setSurname(surname);
	}
	
	//set
	public void setDni (int dni) {
		this.dni = dni;
	}

	public void setEmail (String email) {
		this.email = email;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void setSurname (String surname) {
		this.surname = surname;
	}
	
	public void setPassword (String password) {
		this.password = password;
	}
	
	public void setId (int id) {
		this.id = id;
	}
	
	public void setType (String type) {
		this.type = type;
	}
	
	//get
	public int getDni () {
		return dni;
	}
		
	public String getEmail () {
		return email;
	}
	
	public String getName () {
		return name;
	}
	
	public String getSurname () {
		return surname;
	}
	
	public String getPassword () {
		return password;
	}

	public int getId () {
		return id;
	}
	
	public String getType () {
		return type;
	}
}
