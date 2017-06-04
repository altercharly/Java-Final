package entities;

public class Item {
	
	int idItem;
	int cantStock;
	float price;
	
	//set
	public void setidItem (int id) {
		this.idItem = id;
	}
	
	public void setcantStock (int cant) {
		this.cantStock = cant;
	}
	
	public void setprice (float price) {
		this.price = price;
	}
	
	//get
	public int getidItem () {
		return idItem;
	}
	
	public int getcantStock () {
		return cantStock;
	}
	
	public float getprice () {
		return price;
	}
}
