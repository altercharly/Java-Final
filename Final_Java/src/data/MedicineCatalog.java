package data;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
					"insert into medicine (name, description, generic) values (?,?,?)");
			stmt.setString(1, medicine.getname());
			stmt.setString(2, medicine.getdescription());
			stmt.setInt(3, medicine.getgeneric().getidDrug());
					
			stmt.execute();

			rs=stmt.getResultSet();
			
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

    public void addMedicine2 (Medicine m){
    	  FactoryConnection fc = new FactoryConnection();

          // Pasamos el objeto Connection de nuestra clase "ConexionBD" a esta instancia por medio del m�todo getConnection()
          Connection con = fc.getConn();

          // Crear sentencia SQL para insertar en la base de datos
          String query = "INSERT INTO medicine (name, description, generic) values (?, ?, ?)";

          try {
              Statement st = con.createStatement();
              ResultSet rs = st.executeQuery(query);

              rs.updateString(1, m.getname());
  			rs.updateString(2, m.getdescription());
  			((PreparedStatement) rs).setInt(3, m.getgeneric().getidDrug());

              // Indicamos que comience la actualizaci�n de la tabla en nuestra base de datos
              st.executeUpdate(query);

              // Cerramos las conexiones, en orden inverso a su apertura
              st.close();
              con.close();

              System.out.println("Llamada agregada con �xito a la base de datos.");
          } catch (SQLException e) {
              System.out.println("Error!, la llamada no pudo ser agregada a la base de datos.");
          }
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