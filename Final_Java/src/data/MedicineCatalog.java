package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entities.*;

public class MedicineCatalog {
    //TODO:Create the methods to interact whit the DB
    public Medicine getMedicine (String name) {
        //TODO: select from medicine where medicineName === name
        Medicine medicine = new Medicine();
        medicine = null;

        return medicine
    } 

    public String addMedicine (Medicine medicine) {
        //TODO: Insert the new medicine in the DB
        String message = "New medicine added";

        return message
    }
}