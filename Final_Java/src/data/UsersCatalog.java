package data;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entities.*;

public class UsersCatalog {
	//TODO: create the method to conect with the DB
	public User getUser (int dni) {
		//TODO: get the user by id
		User finduser = null;

		return finduser
	}

	public User addUser (User newUser) {
		//TODO: Insert newuser in the DB and get the new ID
		return newUser
	}

	public String deleteUser (int id) {
		//TODO: find the user by ID and delete it
		String message = "User not found";

		return message
	}
}
