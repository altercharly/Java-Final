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

        return hp
    }

    public String addNewHP (HealthPlan newHP) {
        //TODO: Insert into HealthPlan the newHP
        String message = "New Health Plan added";

        return message
    }
}