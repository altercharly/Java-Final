package entities;

import java.util.Date;

public class Patient {
	
	int idPatient;
	String surname;
	String name;
	int birthdate;
//	int idHP;
	int affiliateNumberHP;
	
	//set
	public void setidPatient (int id) {
		this.idPatient = id;
	}
	
	public void setsurname (String surname) {
		this.surname = surname;
	}
	
	public void setname (String name) {
		this.name = name;
	}
	
	public void setbirthdate (int birthdate) {
		this.birthdate = birthdate;
	}
	
/*	public void setidHP (int idHP) {
		this.idHP = idHP;
	}*/
	
	public void setaffiliateNumberHP (int number) {
		this.affiliateNumberHP = number;
	}
	
	//get
	public int getidPatient () {
		return idPatient;
	}
	
	public String getsurname () {
		return surname;
	}
	
	public String getname () {
		return name;
	}
	
	public int getbirthdate () {
		return birthdate;
	}
	
/*	public int getidHP () {
		return idHP;
	}*/
	
	public int getaffiliateNumberHP () {
		return affiliateNumberHP;
	}
}
