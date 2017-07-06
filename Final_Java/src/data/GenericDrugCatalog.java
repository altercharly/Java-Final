package data;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entities.*;

public class GenericDrugCatalog {
	//TODO: create the method to conect with the DB
    public ArrayList<GenericDrug> getDrugsWithSameGeneric (String generic) {
        ArrayList<GenericDrug> drugs = new ArrayList<GenericDrug>();
        drugs = null;

        return drugs
    }

    public ArrayList<GenericDrug> getgenericDrugs () {
        //TODO: return all the genericdrugs to select one when create a new medicine
        ArrayList<GenericDrug> genericDrugs = new ArrayList<GenericDrug>();
        genericDrugs = null;

        return genericDrugs
    }
}