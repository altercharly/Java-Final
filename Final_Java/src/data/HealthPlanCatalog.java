package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.*;

public class HealthPlanCatalog {
    //TODO: Create the methods to interact whit the DB
    public HealthPlan getHPbyId (int idHP) {
        //TODO: select form HealthPlan where id === idHP
        HealthPlan hp = new HealthPlan();
        hp = null;
        ResultSet rs=null;
		PreparedStatement stmt=null;
		
			try {
			stmt = 	FactoryConnection.getInstancia().getConn().prepareStatement(
					"select nameHP, cantMaxPrescription, idHealthPlan from healthPlan where idHealthPlan = ?"
					);
			stmt.setInt(1, idHP);
			rs = stmt.executeQuery();
			if(rs !=null && rs.next()){
		    	hp.setnameHP(rs.getString("nameHP"));
				hp.setcantMaxPrescription(rs.getInt("cantMaxPrescription"));
				hp.setidHealthPlan(rs.getInt("idHealthPlan"));
				
				
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
        
        return hp;
    }

    public String addNewHP (HealthPlan newHP) {
        //TODO: Insert into HealthPlan the newHP
        String message = "New Health Plan added";
        ResultSet rs=null;
		PreparedStatement stmt=null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"insert into healthPlan (nameHP, cantMaxPrescription) values (?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, newHP.getnameHP());
			stmt.setInt(2, newHP.getcantMaxPrescription());
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
				message = "Professional not added";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			FactoryConnection.getInstancia().releaseConn();
		}
    	
        return message;
        
    }
}