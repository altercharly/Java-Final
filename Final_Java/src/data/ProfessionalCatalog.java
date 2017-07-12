package data;

import java.sql.Date;
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
        ResultSet rs=null;
		PreparedStatement stmt=null;
		
			try {
			stmt = 	FactoryConnection.getInstancia().getConn().prepareStatement(
					"select idProffesional, name, surname, registrationNumber from proffesional where registrationNumber = ?"
					);
			stmt.setInt(1, number);
			rs = stmt.executeQuery();
			if(rs !=null && rs.next()){
		    	pro.setidProffesional(rs.getInt("idProffesional"));
				pro.setname(rs.getString("name"));
				pro.setsurname(rs.getString("surname"));
				pro.setregistrationNumber(rs.getInt("registrationNumber"));
				
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
    	ResultSet rs=null;
		PreparedStatement stmt=null;
		
		
		try {
			stmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"insert into proffesional (name, surname, registrationNumber) values (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, pro.getname());
			stmt.setString(2, pro.getsurname());
			stmt.setInt(3, pro.getregistrationNumber());
					
			stmt.execute();

			rs=stmt.getGeneratedKeys();
			
			if(rs!=null && rs.next()){
			//	pro.setidProffesional(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			try {
				if(rs!=null ) rs.close();
				if(stmt != null) stmt.close();
				String message = "Professional not added";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			FactoryConnection.getInstancia().releaseConn();
		}
    	
    	
    	
    	String message = "Professional added";

        return message;
    }

    public String deleteProfessional (int number) {
        //TODO: Delete from professional where registrationNumber === number
        
    	PreparedStatement stmt=null;
		try {
			stmt = 	FactoryConnection.getInstancia().getConn().prepareStatement(
					"DELETE from proffesional where registrationNumber = ?"
					);
			stmt.setInt(1, number);
			stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(stmt!=null) stmt.close();
				String message = "Professional not deleted";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			FactoryConnection.getInstancia().releaseConn();
		
	
	
	}
    	

		String message = "Professional deleted";
		return message;
    }
}