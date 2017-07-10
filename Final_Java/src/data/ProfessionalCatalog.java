package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entities.*;

public class ProfessionalCatalog {
    //TODO: create the methods to interact with the DB
    public Professional getProByRegistNumber (int number) {
        //TODO: select from professional where registrationNumber === number
        Professional pro = new Professional(); 
        pro = null;

        return pro;
    }

    public String addNewProfessional (Professional pro) {
        //TODO: Insert into the DB the new pro
        String message = "Professional added";

        return message;
    }

    public String deleteProfessional (int number) {
        //TODO: Delete from professional where registrationNumber === number
        String message = "Professional deleted";

        return message;
    }
}