package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import entities.Prescription;

public class PrescriptionCatalog {

	public PrescriptionCatalog() {
		// TODO Auto-generated constructor stub
	}
	public int countPrescriptionsPatient (int idpatient,Date date ){
		int prescriptions =0;
		 ResultSet rs=null;
			PreparedStatement stmt=null;
			// PASAR A METODOS APARTE - OBTENER EL MES!
						
			 Calendar calendar = Calendar.getInstance();
		        calendar.setTime(date); 
		        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); 
		        calendar.add(Calendar.DAY_OF_YEAR, 1);
		        Date lastDayMonth=calendar.getTime(); 
		        
		        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMinimum(Calendar.DAY_OF_MONTH)); 
		        Date firstDayMonth=calendar.getTime();
		        
				try {
				stmt = 	FactoryConnection.getInstancia().getConn().prepareStatement(
						"select count(*) from prescription where idpatient = ? and prescriptionDate >= ? or prescriptionDate < ?"
		);
				stmt.setInt(1, idpatient);
				stmt.setDate(2, (java.sql.Date) firstDayMonth);
				stmt.setDate(3, (java.sql.Date) lastDayMonth);
				rs = stmt.executeQuery();
				if(rs !=null && rs.next()){
			    	prescriptions=rs.getInt(1);
			    	
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
		
		return prescriptions;
	}

	public String addPrescription (Prescription prescription) {
        //TODO: Insert the new prescription in the DB

       ResultSet rs=null;
              PreparedStatement stmt=null;
              String message = "New prescription not added";

              try {
                      stmt = FactoryConnection.getInstancia().getConn().prepareStatement(
                    		  "insert into prescription (idPrescription, prescriptionDate, idpatient, idproffesional,total) values (?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                      stmt.setInt(1, prescription.getidPrescription());
                      stmt.setDate(2, (java.sql.Date) prescription.getprescriptionDate());
                      stmt.setInt(3, prescription.getidpatient());
                      stmt.setInt(4, prescription.getidproffesional());
                      stmt.setDouble(5, prescription.getTotal());
                      stmt.execute();

                      rs=stmt.getGeneratedKeys();

                      if(rs!=null && rs.next()){
                               message = "New prescription added";
                      }

              } catch (SQLException e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
              }
              finally{

                      try {
                              if(rs!=null ) rs.close();
                              if(stmt != null) stmt.close();
                              message = "New prescription not added";
                      } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();

                      }

                      FactoryConnection.getInstancia().releaseConn();
              }

       

        return message;
    }



}
