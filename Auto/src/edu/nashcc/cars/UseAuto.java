/* Daniel Batts & Matthew S. Coley
 * Ch 11 program #3
 * 2 July 2015
 */

package edu.nashcc.cars;

import java.text.DecimalFormat;
import java.util.Scanner;

public class UseAuto {

	public static void main(String[] args) {
		String choice = userInput(makeOptions());
		switch(choice){
		case "1":
			Chevy ch = new Chevy();
			String chevyChoice = userInput(ch.modelOptions());
			ch.setModel(chevyChoice);
			display(createString(ch));
			break;
		case "2":
			Ford fo = new Ford();
			String fordChoice = userInput(fo.modelOptions());
			fo.setModel(fordChoice);
			display(createString(fo));
			break;
		default:
			display("You dun goofed");
		}
		
	} // end of main()
	
	public static String userInput(String options){
		String choice;
		Scanner kb = new Scanner(System.in);
		System.out.println(options);
		choice = kb.nextLine();
		//kb.close();
		return choice;
		
	}
	public static String makeOptions(){
		StringBuilder sb = new StringBuilder();
		sb.append("1 to select Chevy\n");
		sb.append("2 to select Ford\n");
		return sb.toString();
	}
	public static String createString(Auto auto){
		StringBuilder sb = new StringBuilder();
		sb.append("This ");
		sb.append(auto.getMake());
		sb.append(" ");
		sb.append(auto.getModel());
		sb.append(" costs ");
		sb.append(decForm(auto.getPrice()));
		return sb.toString();
	}
	public static void display(String prompt){
		System.out.println(prompt);
	}
	private static String decForm(double decimal) {
		DecimalFormat formatter = new DecimalFormat("$#,##0.00");
		return formatter.format(decimal);
	}

}
