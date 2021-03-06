/*	Matthew S. Coley
 * 	Simple Four Function Calculator Using WindowBuilder
 * 	21 July 2015
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Calculator {

	private JFrame frmCalculator;
	private JTextField firstNum;
	private JTextField secondNum;
	private String answer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setTitle("Simple Calculator");
		frmCalculator.setBounds(100, 100, 450, 300);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		firstNum = new JTextField();
		firstNum.setBounds(64, 49, 86, 20);
		frmCalculator.getContentPane().add(firstNum);
		firstNum.setColumns(10);
		
		secondNum = new JTextField();
		secondNum.setBounds(64, 129, 86, 20);
		frmCalculator.getContentPane().add(secondNum);
		secondNum.setColumns(10);
		
		JLabel lblFirstNumber = new JLabel("First Number");
		lblFirstNumber.setBounds(64, 35, 134, 14);
		frmCalculator.getContentPane().add(lblFirstNumber);
		
		JLabel lblSecondNumber = new JLabel("Second Number");
		lblSecondNumber.setBounds(64, 115, 134, 14);
		frmCalculator.getContentPane().add(lblSecondNumber);
		
		JLabel lblAnswer = new JLabel("ANSWER:");
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAnswer.setBounds(208, 75, 213, 35);
		frmCalculator.getContentPane().add(lblAnswer);
		
		JButton plusButton = new JButton("+");
		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// check each text field for a valid number
				double num1, num2;
				try
				{
					num1 = Double.parseDouble(firstNum.getText());
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(frmCalculator, "Invalid First Number!", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try
				{
					num2 = Double.parseDouble(secondNum.getText());
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(frmCalculator, "Invalid Second Number!", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				// try the math
				try
				{
					double ans = num1 + num2;
					answer = Double.toString(ans);
					lblAnswer.setText("ANSWER: \t" + answer);
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(frmCalculator, exc, "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		plusButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		plusButton.setBounds(10, 180, 89, 23);
		frmCalculator.getContentPane().add(plusButton);
		
		JButton subButton = new JButton("-");
		subButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// check each text field for a valid number
				double num1, num2;
				try
				{
					num1 = Double.parseDouble(firstNum.getText());
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(frmCalculator, "Invalid First Number!", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try
				{
					num2 = Double.parseDouble(secondNum.getText());
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(frmCalculator, "Invalid Second Number!", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				// try the math
				try
				{
					double ans = num1 - num2;
					answer = Double.toString(ans);
					lblAnswer.setText("ANSWER: \t" + answer);
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(frmCalculator, exc, "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		subButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		subButton.setBounds(109, 180, 89, 23);
		frmCalculator.getContentPane().add(subButton);
		
		JButton multiButton = new JButton("*");
		multiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// check each text field for a valid number
				double num1, num2;
				try
				{
					num1 = Double.parseDouble(firstNum.getText());
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(frmCalculator, "Invalid First Number!", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try
				{
					num2 = Double.parseDouble(secondNum.getText());
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(frmCalculator, "Invalid Second Number!", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				// try the math
				try
				{
					double ans = num1 * num2;
					answer = Double.toString(ans);
					lblAnswer.setText("ANSWER: \t" + answer);
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(frmCalculator, exc, "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		multiButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		multiButton.setBounds(233, 180, 89, 23);
		frmCalculator.getContentPane().add(multiButton);
		
		JButton divButton = new JButton("/");
		divButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// check each text field for a valid number
				double num1, num2;
				try
				{
					num1 = Double.parseDouble(firstNum.getText());
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(frmCalculator, "Invalid First Number!", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try
				{
					num2 = Double.parseDouble(secondNum.getText());
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(frmCalculator, "Invalid Second Number!", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				// try the math
				try
				{
					double ans = num1 / num2;
					answer = Double.toString(ans);
					lblAnswer.setText("ANSWER: \t" + answer);
				}
				catch(ArithmeticException error)
				{
					JOptionPane.showMessageDialog(frmCalculator, error, "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				catch(Exception exc)
				{
					JOptionPane.showMessageDialog(frmCalculator, exc, "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		divButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		divButton.setBounds(332, 180, 89, 23);
		frmCalculator.getContentPane().add(divButton);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNum.setText("");
				secondNum.setText("");
				lblAnswer.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClear.setBounds(335, 11, 89, 23);
		frmCalculator.getContentPane().add(btnClear);
		

	}
}
