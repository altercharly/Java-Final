package data;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.*;

public class GenericDrugCatalog {
	//TODO: create the method to conect with the DB


    public ArrayList<GenericDrug> getgenericDrugs () {
        //TODO: return all the genericdrugs to select one when create a new medicine
        ArrayList<GenericDrug> genericDrugs = new ArrayList<GenericDrug>();
        genericDrugs = null;
 		
		String sql="select iddrug, drugName from genericdrug";
		PreparedStatement sentencia=null;
		ResultSet rs=null;
		Connection con = FactoryConnection.getInstancia().getConn();
		try 
		{			
			sentencia= con.prepareStatement(sql);
			rs= sentencia.executeQuery();
			while (rs !=null && rs.next()){
				GenericDrug drug = new GenericDrug();
				drug.setidDrug(rs.getInt("iddrug"));
				drug.setdrugName(rs.getString("drugName"));
				
				genericDrugs.add(drug);
			}
			
				
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null)
				{
					rs.close();
				}
				if(sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				FactoryConnection.getInstancia().releaseConn();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}
        return genericDrugs;
    }

    public String saveNewgenericDrug (GenericDrug drug) {
        //TODO: save in the DB the new genericdrugs and return de new ID (optional)
    	ResultSet rs=null;
		PreparedStatement stmt=null;
		
		
		try {
			stmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"insert into genericdrug (name) values (?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, drug.getdrugName());	
			stmt.execute();
			rs=stmt.getGeneratedKeys();
			
			if(rs!=null && rs.next()){
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			try {
				if(rs!=null ) rs.close();
				if(stmt != null) stmt.close();
				String message = "Generic drug not added";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			FactoryConnection.getInstancia().releaseConn();
		}
    	
 
    	String message = "Generic drug added";

        return message;
    }

	public GenericDrug getGenericDrug(String drugname) {
		//TODO: return all the genericdrugs to select one when create a new medicine
        GenericDrug gdrug = new GenericDrug();
        ResultSet rs=null;
		PreparedStatement stmt=null;
		
			try {
			stmt = 	FactoryConnection.getInstancia().getConn().prepareStatement(
					"select * from genericdrug where name = ?"
					);
			stmt.setString(1, drugname);
			rs = stmt.executeQuery();
			if(rs !=null && rs.next()){
		    	gdrug.setidDrug(rs.getInt("idDrug"));
				gdrug.setdrugName(rs.getString("name"));
				
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
        
        return gdrug;
	}
}