package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

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
}
