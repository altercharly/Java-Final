package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import entities.Item;
import entities.Prescription;
import entities.Prescription_Item;

public class ItemCatalog {

	public ItemCatalog() {
		// TODO Auto-generated constructor stub
	}
	public void addItem (Item item) {

        //TODO: Insert the new item in the DB

       ResultSet rs=null;
              PreparedStatement stmt=null;
              

              try {
                      stmt = FactoryConnection.getInstancia().getConn().prepareStatement(
                    		  "insert into item (idmedicine,idpresentation, cantStock, price) values (?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                      stmt.setInt(1, item.getIdmedicine());
                      stmt.setInt(2, item.getIdpresentation());
                      stmt.setInt(3, item.getcantStock());
                      stmt.setFloat(4, item.getprice());
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
                              
                      } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();

                      }

                      FactoryConnection.getInstancia().releaseConn();}}
              

       




	public void updateItem(Item item){
	ResultSet rs=null;
	PreparedStatement stmt=null;
	
	
	try {
		stmt = FactoryConnection.getInstancia().getConn().prepareStatement(
				"Update item set idmedicine=?, idpresentation=?, price=?, cantStock=?, where idItem=?");
		
		stmt.setInt(1, item.getidItem());
		stmt.setInt(2, item.getIdmedicine());
		stmt.setDouble(3, item.getprice());
		stmt.setInt(4,item.getcantStock());
			
		stmt.execute();

		//rs=stmt.getGeneratedKeys();
		
		if(rs!=null && rs.next()){
		//	pacient.setId(rs.getInt(1));
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
	}}

    



           
}