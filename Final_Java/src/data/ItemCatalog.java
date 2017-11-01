package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.util.ArrayList;

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

    



           

	public ArrayList<Item> getItemsbyPrescription (int idmedicine) {
        //TODO: select from item where idmedicine = idmedicine
        		ResultSet rs=null;
               PreparedStatement stmt=null;
               ArrayList<Item> items = new  ArrayList<Item>();
                       try {
                       stmt =   FactoryConnection.getInstancia().getConn().prepareStatement(
                                       "select iditem, idpresentation, idmedicine, price, cantstock from item where idmedicine = ?");
                       stmt.setInt(1, idmedicine);
                       rs = stmt.executeQuery();
                       if(rs !=null && rs.next()){
                               Item i = new Item();
                               i.setidItem(rs.getInt("iditem"));
                               i.setIdpresentation(rs.getInt("idpresentation"));
                               i.setIdmedicine(rs.getInt("idmedicine"));
                               i.setprice(rs.getFloat("price"));
                               i.setcantStock(rs.getInt("cantstock"));
                               items.add(i);

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
        return items;
    }

}