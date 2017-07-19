package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.GenericDrug;
import entities.Medicine;
import entities.Patient;

public class PatientCatalog {

	public PatientCatalog() {
		// TODO Auto-generated constructor stub
	
	}
    public Patient getPatient (int aNumber) {
        //TODO: select from patient where affiliateNumberHP == aNumber
        Patient patient = new Patient();
        patient = null;

        ResultSet rs=null;
		PreparedStatement stmt=null;
		
			try {
			stmt = 	FactoryConnection.getInstancia().getConn().prepareStatement(
					"select affiliateNumberHP, birthdate, idPatient, name, surname from patient where affiliateNumberHP = ?"
	);
			stmt.setInt(1, aNumber);
			rs = stmt.executeQuery();
			if(rs !=null && rs.next()){
		    	patient.setaffiliateNumberHP(rs.getInt("affiliateNumberHP"));
		    	patient.setbirthdate(rs.getDate("birthdate"));
				patient.setname(rs.getString("name"));
				patient.setidPatient(rs.getInt("idPatient"));
				patient.setsurname(rs.getString("surname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConnection.getInstancia().releaseConn();
		}
        
        return patient;
    } 

    public String addPatient (Patient patient) {
    	ResultSet rs=null;
		PreparedStatement stmt=null;
		String message = "Patient not added";
		
		try {
			stmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"insert into patient (name, surname, affiliateNumberHP, birthdate,) values (?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, patient.getname());
			stmt.setString(2, patient.getsurname());
			stmt.setInt(3, patient.getaffiliateNumberHP());
			stmt.setDate(4, (Date) patient.getbirthdate());
			stmt.execute();
			rs=stmt.getGeneratedKeys();
			
			if(rs!=null && rs.next()){
				message = "Pacient added";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			try {
				if(rs!=null ) rs.close();
				if(stmt != null) stmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			FactoryConnection.getInstancia().releaseConn();
		}
    	
        return message;
    }


}
