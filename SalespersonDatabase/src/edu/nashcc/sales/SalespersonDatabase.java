package edu.nashcc.sales;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SalespersonDatabase {

	public static void main(String[] args) {
		// creating 20 item arraylist
		ArrayList<Object> salespersonDB = new ArrayList<Object>(20);

		// user input + StringBuilder for initial prompt
		StringBuilder sb = new StringBuilder();
		sb.append("What would you like to do?\n\n");
		sb.append("1 --- Add an item to the list.\n");
		sb.append("2 --- Delete an item from the list.\n");
		sb.append("3 --- Change an item on the list.\n");
		sb.append("0 --- QUIT");
		String userChoice = userInput(sb.toString());

		while (!userChoice.equals("0")) {
			String userID;
			int userSales;
			switch (userChoice) {
			case "1":
				if (salespersonDB.size() < 20) { // ArrayList has isEmpty()
													// method
					userID = userInput("Enter the salesperson ID you wish to add:");
					userSales = Integer
							.parseInt(userInput("Enter the sales amount:"));
					Salesperson sp = new Salesperson(userID, userSales);
					salespersonDB.add(sp);
					// move under Switch -- double userSales =
					// Double.parseDouble(userInput("Enter the sales amount:"));
				} else {
					errorMsg("full");
				}
				break;
			case "2":
				if (salespersonDB.isEmpty()) {
					errorMsg("empty");
				} else {
					userID = userInput("Enter the salesperson ID you wish to remove:");
					salespersonDB.remove(userID); // going to error, no userID
													// in list, is a salesperson
													// object
				}
				break;
			case "3":
				userID = userInput("Enter the ID you wish to change:");
				if (salespersonDB.isEmpty()) {
					errorMsg("empty");
				} else if (!salespersonDB.contains(userID)) {
					JOptionPane.showMessageDialog(null,
							"That ID does not exist.");
				} else {
					String newID = userInput("Enter the new ID:");
					salespersonDB.remove(userID); // FIX: Salesperson object,
													// not userID
					salespersonDB.add(newID);
				}

				// Salesperson salesperson[i] = new Salesperson(ID, sales);
				// http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html

				// user input for ID and sales -- move/delete?
				// int ID = Integer.parseInt(userInput("Enter the ID: "));
				// double sales =
				// Double.parseDouble(userInput("Enter the sales amount: "));

			}

			// updating userChoice
			userChoice = userInput(sb.toString());
		
		} // end while(userChoice != "0")
	}

	public static String userInput(String prompt) {
		return JOptionPane.showInputDialog(null, prompt);
	}

	public static void errorMsg(String prompt) {
		JOptionPane.showMessageDialog(null, "Database is " + prompt + ".");
	}

}
