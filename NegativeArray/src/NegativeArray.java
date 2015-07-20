//Program: Create a Try/Catch Block for the Provided Program:
import javax.swing.*;
public class NegativeArray{
	public static void main(String args[]){
		int a[];
		int sz;
		String size;

		try
		{
		size = JOptionPane.showInputDialog(null,
				"Please enter a value for the array size");
		sz = Integer.parseInt(size);
		a = new int[sz];
		JOptionPane.showMessageDialog(null, "Array of size " + sz + " created");
		}
		catch(Exception e) // default catch
		{
			JOptionPane.showMessageDialog(null, "Error:\n" + e);
		}
	}
}