package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.FactoryConnection;

import entities.*;

public class ProfessionalCatalog {
    //TODO: create the methods to interact with the DB
   
	public Professional getProByRegistNumber (int number) {
        //TODO: select from professional where registrationNumber === number
        Professional pro = new Professional(); 
        pro = null;
      //sirve para buscar una persona mediante un dni
		ResultSet rs=null;
PreparedStatement stmt=null;

	try {
	stmt = 	FactoryConnection.getInstancia().getConn().prepareStatement(
			"select name, surname, registrationNumber, idProffesional from proffesional where registrationNumber = ?"
			);
	stmt.setInt(1, number);
	rs = stmt.executeQuery();
	if(rs !=null && rs.next()){
    	pro.setname(rs.getString("name"));
		pro.setsurname(rs.getString("surname"));
		pro.setregistrationNumber(rs.getInt("registrationNumber"));
		pro.setidProffesional(rs.getInt("idProffesional"));
		
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
        return pro;
    }

    public String addNewProfessional (Professional pro) {
        //TODO: Insert into the DB the new pro
        String message = "Professional added";

        return message;
    }

    public String deleteProfessional (int number) {
        //TODO: Delete from professional where registrationNumber === number
        String message = "Professional deleted";

        return message;
    }
}