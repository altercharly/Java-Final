package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.*;

public class MedicineCatalog {
    //TODO:Create the methods to interact whit the DB
    public Medicine getMedicine (String name) {
        //TODO: select from medicine where medicineName === name
        Medicine medicine = new Medicine();
        medicine = null;

        ResultSet rs=null;
		PreparedStatement stmt=null;
		
			try {
			stmt = 	FactoryConnection.getInstancia().getConn().prepareStatement(
					"select description, name, generic, idMedicine from medicine where medicineName = ?"
					);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			if(rs !=null && rs.next()){
		    	medicine.setdescription(rs.getString("description"));
				medicine.setname(rs.getString("name"));
				medicine.setidMedicine(rs.getInt("idMedicine"));
				
				GenericDrug genericDrug =null;
				genericDrug.setidDrug((rs.getInt("generic")));
				medicine.setgenericDrugs(genericDrug);
				
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
        
        return medicine;
    } 

    public String addMedicine (Medicine medicine) {
        //TODO: Insert the new medicine in the DB
       
    	ResultSet rs=null;
		PreparedStatement stmt=null;
		
		
		try {
			stmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"insert into medicine (name, description, generic) values (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, medicine.getname());
			stmt.setString(2, medicine.getdescription());
			stmt.setInt(3, medicine.getgeneric().getidDrug());
					
			stmt.execute();

			rs=stmt.getGeneratedKeys();
			
			if(rs!=null && rs.next()){
				String message = "New medicine added";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			try {
				if(rs!=null ) rs.close();
				if(stmt != null) stmt.close();
				String message = "New medicine not added";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				String message = "Professional not added";
			}
			
			FactoryConnection.getInstancia().releaseConn();
		}
    	
    	String message = "New medicine added";

        return message;
    }

    public ArrayList<Medicine> getMedicineWithSameGeneric (int generic) {
        //TODO: Think a little more about this method, the idea is get all the medicine whit that generic
        ArrayList<Medicine> medicines = new ArrayList<Medicine>();
        medicines = null;
        
        String sql="select * from medicine where generic = ?";
		PreparedStatement sentencia=null;
		ResultSet rs=null;
		
		Connection con = FactoryConnection.getInstancia().getConn();
		try 
		{			
			sentencia= con.prepareStatement(sql);
			sentencia.setInt(1, generic );
			rs= sentencia.executeQuery();
			
			while (rs !=null && rs.next()){
				Medicine medicine = new Medicine();
				medicine.setidMedicine(rs.getInt("idMedicine"));
				medicine.setdescription(rs.getString("description"));
				medicine.setname(rs.getString("name"));
				GenericDrug drug = null;
				drug.setidDrug(rs.getInt("generic"));
				medicine.setgenericDrugs(drug);
				medicines.add(medicine);
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
        
        return medicines;
    }

}