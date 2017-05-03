package entities;

public class User {

	int dni;
	String email;
	String surname;
	String name;
	int id;		
	String password;
	
	public User(){	
		
	}
    
    
	public User(int dni, String name, String surname){
		setDni(dni);
		setName(name);
		setSurname(surname);
	}
	
	public void setDni (int dni) {
		this.dni = dni;
	}
	
	public int getDni () {
		return dni;
	}
	
	public void setEmail (String email) {
		this.email = email;
	}
	
	public String getEmail () {
		return email;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getName () {
		return name;
	}
	
	public void setSurname (String surname) {
		this.surname = surname;
	}
	
	public String getSurname () {
		return surname;
	}
	
	public void setPassword (String password) {
		this.password = password;
	}
	
	public String getPassword () {
		return password;
	}
	
	public void setId (int id) {
		this.id = id;
	}

	public int getId () {
		return id;
	}
	
}
